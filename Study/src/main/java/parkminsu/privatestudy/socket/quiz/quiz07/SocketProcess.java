package parkminsu.privatestudy.socket.quiz.quiz07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class SocketProcess {
    private boolean transfer;

    public SocketProcess() {
        this.transfer = false;
    }

    /**
     * @param br user input data
     */
    public void send(BufferedReader br, BufferedWriter bw) {

        try {
            String data = br.readLine();
            bw.write(data + "\n");
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void receive(BufferedReader br, BufferedWriter bw) {
        try {
            String data = br.readLine();
            bw.write(data + "\n");
            bw.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
