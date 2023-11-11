package parkminsu.privatestudy.socket.quiz.quiz07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Sender implements Runnable {
    private Thread thread;
    private BufferedReader sendReader;
    private BufferedWriter sendWriter;
    private SocketProcess socketProcess;

    public Sender(String name, BufferedReader br, BufferedWriter bw) {
        this.socketProcess = new SocketProcess();
        this.thread = new Thread(name);
        sendReader = br;
        sendWriter = bw;
    }

    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.thread.interrupt();
    }

    /**
     * 클라이언트가 서버로 데이터를 보냄
     */
    @Override
    public void run() {
        while (true) {
            try {
                String data = sendReader.readLine();
                if (data.equals("exit")) {
                    break;
                }
                sendWriter.write(data + "\n");
                sendWriter.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
