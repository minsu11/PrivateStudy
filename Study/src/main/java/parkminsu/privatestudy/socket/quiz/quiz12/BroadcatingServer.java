package parkminsu.privatestudy.socket.quiz.quiz12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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
        try (ServerSocket serverSocket = new ServerSocket(port)) { // server open
            System.out.println("대기중 ");
            while (!Thread.currentThread().isInterrupted()) { // 서버 소켓의 loop
                Socket socket = serverSocket.accept();
                System.out.println("서버 연결");
                ServerThread serverThread = new ServerThread(socket);

                serverThread.start();
            }
        } catch (IOException e) {
            System.err.println("연결이 잘못 되었습니다");
        }
    }
}

class ServerThread extends Thread {
    static List<ServerThread> serverThreads = new ArrayList<>();
    private final Socket socket;
    BufferedWriter socketOut;


    public ServerThread(Socket socket) {
        this.socket = socket;
        serverThreads.add(this);
    }

    public void send(String message) throws IOException {
        this.socketOut.write(message);
        this.socketOut.flush();
    }

    /**
     * 생각한 방식
     * 1. while문 조건문에서 length가 0 이상이거나 다른 값이 들어왔을 때 while문을 작동하게 만들려고함
     * 2. 근데 지금 문제가 length랑
     */
    @Override
    public void run() {
        try (
                BufferedReader socketIn = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()))
        ) {
            String str = "";
            this.socketOut = socketOut;
            while (!Thread.currentThread().isInterrupted()) {
                str = socketIn.readLine();
                for (ServerThread s : serverThreads) {
                    s.send(str);
                }

            }
        } catch (IOException e) {

        }

    }

}
