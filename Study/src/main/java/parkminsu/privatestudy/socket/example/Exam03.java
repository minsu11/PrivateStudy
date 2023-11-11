package parkminsu.privatestudy.socket.example;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Exam03 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;
        int ch = 0;
        if (args.length > 0) {
            host = args[0];
        }
        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        }

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");
            while ((ch = socket.getInputStream().read()) >= 0) {
                System.out.write(ch);
            }
        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        }
    }
}
