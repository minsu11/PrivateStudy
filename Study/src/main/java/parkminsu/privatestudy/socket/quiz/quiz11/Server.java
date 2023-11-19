package parkminsu.privatestudy.socket.quiz.quiz11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8080;
        try {
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.err.println("잘못 입력");
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                System.out.println("대기중");
                Socket socket = serverSocket.accept();
                System.out.println("서번 연결");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }


        } catch (IOException e) {
            System.err.println("연결이 끊어졌습니다");
        }

    }
}

class ServerThread extends Thread {
    private final int BUFFER_SIZE = 2048;
    private Socket socket;
    private static int clientCount = 0;

    public ServerThread(Socket socket) {
        clientCount = addClientCount(clientCount);
        this.socket = socket;
    }

    private int addClientCount(int client) {
        client += 1;
        return client;
    }


    @Override
    public void run() {
        try (
                BufferedInputStream bs = new BufferedInputStream(this.socket.getInputStream());
                BufferedOutputStream bo = new BufferedOutputStream(this.socket.getOutputStream())
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = bs.read(buffer)) > 0) {
                bo.write(buffer, 0, length);
                bo.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

