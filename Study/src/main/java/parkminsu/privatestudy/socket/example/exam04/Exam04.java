package parkminsu.privatestudy.socket.example.exam04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam04 {
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
            System.err.println("잘못 입력하셨습니다");
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();
            System.out.println("서버에 연결됐습니다");
            socket.getOutputStream().write("Hello!".getBytes());
            socket.getOutputStream().flush();
        } catch (IOException e) {
            System.err.println(e);
        }


    }
}
