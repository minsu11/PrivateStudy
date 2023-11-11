package parkminsu.privatestudy.socket.quiz.quiz09;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Quiz09 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;

        if (args.length > 0) {
            host = args[0];
        }
        try {

            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.err.println("입력을 잘못했습니다");
        }
        try (Socket socket = new Socket(host, port)) {
            String inputData = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            BufferedWriter serverOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedInputStream serverIn = new BufferedInputStream(socket.getInputStream());
            byte[] buffer = new byte[2048];
            int length;
            String str;
            while (true) {
                inputData = br.readLine();
                if (inputData.equals("exit")) {
                    break;
                }
                serverOut.write(inputData + "\n");
                serverOut.flush();

                length = serverIn.read(buffer);
                str = new String(buffer, StandardCharsets.UTF_8);
                bw.write("서버에서 보냄: " + str);
                bw.newLine();
                bw.flush();
            }
            br.close();
            bw.close();
            serverIn.close();
            serverOut.close();
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결이 잘못됐습니다.");
        }
    }
}
