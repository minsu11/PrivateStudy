package parkminsu.privatestudy.socket.quiz.quiz12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BroadcatingServer {
    public static void main(String[] args) {
        int port = 1234;
        try {

            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.err.println("입력 값이 잘못됐습니다");
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("대기중 ");
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("서버 연결");
                    ServerThread serverThread = new ServerThread(socket);
                    serverThread.start();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("연결이 잘못 되었습니다");
        }
    }
}

class ServerThread extends Thread {
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(this.socket.getInputStream());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.socket.getOutputStream());) {
            
        } catch (IOException e) {

        }

    }

}
