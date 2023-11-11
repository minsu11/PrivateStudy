package parkminsu.privatestudy.socket.quiz.quiz11;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Quiz11 {
    /**
     * Thread를 사용하여 client가 다중으로 들어오게 만들어라
     */

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;
        if (args.length > 0) {
            host = args[0];
        }
        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.err.println("잘못 입력했습니다.");
        }

        try (Socket socket = new Socket(host, port);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
             BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            String inputData;
            System.out.println("서버에 연결");
            byte[] buffer = new byte[2048];
            while (true) {
                inputData = br.readLine();
                if (inputData.equalsIgnoreCase("exit")) {
                    break;
                }
                socketOut.write(inputData);
                socketOut.flush();
                
                int length = socketIn.read(buffer);
                inputData = new String(buffer, StandardCharsets.UTF_8);
                bw.write(inputData);
                bw.newLine();
                bw.flush();

            }
        } catch (IOException e) {
            System.out.println(host + ":" + port + "에 연결하지 못했습니다.");
        }
    }
}
