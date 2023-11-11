package parkminsu.privatestudy.socket.quiz.quiz08;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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
            System.out.println("입력값이 잘못됐습니다");
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();
            System.out.println("Client[" +
                    socket.getLocalAddress() + ":" + socket.getPort() + "]가 연결되었습니다.");
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");

        }

    }
}
