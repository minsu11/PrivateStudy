import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.apache.commons.cli.*;

/**
 * 네트워크 공부하기 위한 용도여서 나중에 정리를 해야함
 */
public class SimpleCurl {
    //TODO code refactoring 
    private static final Options OPTIONS = new Options();

    private static void settingOptions() {
        OPTIONS.addOption(Option.builder("v")
                .desc("verbose, 요청, 응답 헤더를 출력")
                .build());

        OPTIONS.addOption(Option.builder("H")
                .hasArg()
                .valueSeparator(':')
                .argName("line")
                .desc("임의의 헤더를 서버로 전송")
                .build());

        OPTIONS.addOption(Option.builder("d")
                .hasArg()
                .argName("data")
                .desc("POST, PUT 등에 데이터 전송")
                .build());

        OPTIONS.addOption(Option.builder("X")
                .hasArg()
                .argName("command")
                .desc("사용할 method 지정. 지정 되지 않은 경우, 기본 값은 GET")
                .build());

        OPTIONS.addOption(Option.builder("L")
                .desc("서버의 응답이 30x 계열 이면 다음 응답을 따라 감")
                .build());

        OPTIONS.addOption(Option.builder("F")
                .numberOfArgs(2)
                .argName("name=content")
                .valueSeparator('=')
                .desc("multipart/form-data 구성 하여 전송. content 부분에 @filename 사용할 수 있음")
                .build());
    }

    public static void main(String[] args) throws ParseException, IOException {

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        settingOptions();
        cmd = parser.parse(OPTIONS, args);
        String[] cmdParserString = cmd.getArgs();
        String data = "";

        URL url = new URL(cmdParserString[cmdParserString.length - 1]);
        String urlHost = url.getHost();
        String urlPath = url.getPath();
        System.out.println(urlHost);
        String state = "GET";
        if (cmd.hasOption("X")) {
            state = cmd.getOptionValue("X");
            System.out.println(state);
            if (state.equalsIgnoreCase("POST")) {
                data = cmd.getOptionValue("H") + "\r\nContent-Length: " + cmd.getOptionValue("d").length() + "\r\n\r\n" + cmd.getOptionValue("d");

                System.out.println(data);

            }
        } else if (cmd.hasOption("v")) {
            if (cmd.hasOption("H")) {
                data = cmd.getOptionValue("H") + "\r\n";
            }
        } else if (cmd.hasOption("F")) {
            state = "POST";
            String[] paths = cmd.getOptionProperties("F").toString().split("/");
            StringBuilder path = new StringBuilder();
            path.append("/");
            for (int i = 1; i < paths.length; i++) {
                path.append(paths[i]).append("/");
            }
            String p = path.toString().replace("}", "");
            String boundary = "boundaryData";

            String strLength = "--" + boundary + "\r\n" +
                    "Content-Disposition: form-data; name=\"upload\"; filename=\"test.txt\"\r\n " +
                    "\r\nhihihi\r\n" +
                    "--" + boundary + "--\r\n";

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("--" + boundary + "\r\n")
                    .append("Content-Disposition: form-data; name=\"upload\"; filename=\"test.txt\"\r\n ")
                    .append("\r\nhihihi\r\n")
                    .append("--" + boundary + "--\r\n");


            data = createHttpRequest("POST", "/Users/minsu/Desktop/PrivateStudy/Study/src/main/java/parkminsu/privatestudy/test.txt", 'c');

        }

        try (
                Socket socket = new Socket(urlHost, 80);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        ) {
            System.out.println("서버 연결 ");
            String outData = createCurl(urlHost, urlPath, state, data);
            bw.write(data);

            bw.newLine();
            bw.flush();
            String line;
            socket.setSoTimeout(3000);
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("연결이 안됨");
        }

    }

    public static String createCurl(String url, String path, String state, String data) {
        // state = GET, Post, Put?
        StringBuilder stringBuilder = new StringBuilder();

        if (state.equalsIgnoreCase("get")) {
            stringBuilder.append(state.toUpperCase() + " ").append(path).append(" HTTP/1.1\r\n")
                    .append("Host: ").append(url).append("\r\n")
                    .append("User-Agent: curl/8.1.2\r\n")
                    .append("Accept: */*\r\n");
            if (data != null) {
                stringBuilder.append(data);
            }
        } else if (state.equalsIgnoreCase("post")) {
            stringBuilder.append(state.toUpperCase() + " ").append(path).append(" HTTP/1.1\r\n")
                    .append("Host: ").append(url).append("\r\n")
//                    .append("User-Agent: curl/8.1.2\r\n")
//                    .append("Accept: */*\r\n")
                    .append(data);
            System.out.println(stringBuilder.toString());

        }


        return stringBuilder.toString();
    }

    private static String createHttpRequest(String method, String fileName, char arg)
            throws IOException {
        File file = new File(fileName);
        String boundary = "abc";

        StringBuilder content = new StringBuilder("");
        content.append("--").append(boundary).append("\r\n");
        content.append("Content-Disposition: form-data; name=\"upload\"; filename=\"test.txt\"\r\n\r\n");
        content.append("hi~~ my name is kaeun!!\r\n");
        content.append("--").append(boundary).append("--\r\n");

        StringBuilder request = new StringBuilder();
        request.append(method).append(" ").append("/post").append(" HTTP/1.1\r\n");
        request.append("Host: httpbin.org\r\n");
        request.append("Content-Length: ").append(content.length()).append("\r\n");
        request.append("Content-Type: multipart/form-data; boundary=").append(boundary).append("\r\n\r\n");


        request.append(content);


        return request.toString();
    }

}
