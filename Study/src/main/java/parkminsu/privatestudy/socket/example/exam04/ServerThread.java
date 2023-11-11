package parkminsu.privatestudy.socket.example.exam04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Thread thread;
    private final int port = 1234;

    public ServerThread() {
        thread = new Thread();
    }

    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.thread.interrupt();
    }

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            try (ServerSocket serverSocket = new ServerSocket(this.port)) {
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트와 연결되었습니다");
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String str;
                while (true) {
                    str = br.readLine();
                    if (str.equals("exit")) {
                        break;
                    }
                    bw.write(str + "\n");
                    bw.flush();
                }

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
