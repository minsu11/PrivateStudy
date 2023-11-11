package parkminsu.privatestudy.socket.quiz.quiz10;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Quiz10 {
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
            System.out.println("포트번호를 잘못 입력하셨습니다");
        }

        try (Socket socket = new Socket(host, port);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
             BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

            String str = "";
            int length;
            byte[] buffer = new byte[2048];
            while (true) {
                str = bufferedReader.readLine();
                if (str.equalsIgnoreCase("exit")) {
                    break;
                }
                socketOut.write(str);
                socketOut.flush(); // 입력 값

                length = socketIn.read(buffer);
                str = new String(buffer, StandardCharsets.UTF_8);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }


        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결 할 수 없습니다.");
        }
    }
}
