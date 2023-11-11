package parkminsu.privatestudy.socket.quiz.quiz07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Receive implements Runnable {
    private Thread thread;
    private BufferedReader clientIn;
    private BufferedWriter clientOut;
    private SocketProcess socketProcess;

    public Receive(String name, BufferedReader br, BufferedWriter bw) {
        socketProcess = new SocketProcess();
        this.thread = new Thread(name);
        this.clientIn = br;
        this.clientOut = bw;
    }


    public void start() {
        this.thread.start();
    }

    public void stop() {
        this.thread.interrupt();
    }

    public Thread getThread() {
        return thread;
    }

    /**
     * server에서 보낸 데이터의 값을 받음
     */
    @Override
    public void run() {
        while (true) {
            try {
                String data = clientIn.readLine();
                System.out.println(data);
                clientOut.write(data + "\n");
                clientOut.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
