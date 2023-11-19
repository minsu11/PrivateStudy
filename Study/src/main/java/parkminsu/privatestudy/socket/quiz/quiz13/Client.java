package parkminsu.privatestudy.socket.quiz.quiz13;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;
        String id = "client";
        Random random = new Random();
        int idx = random.nextInt(10);
        if (args.length > 0) {
            host = args[0];
        }
        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.out.println("포트 번호를 잘못입력하셨습니다");
        }
        try (
                Socket socket = new Socket(host, port);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            System.out.println("서버에 연결했습니다.");
            String data;
            bufferedWriter.write(id + idx);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            idx++;
            while (!Thread.currentThread().isInterrupted()) {

            }
        } catch (IOException e) {
            System.out.println("연결 할 수 없습니다");
        }
    }
}

// 대상 아이디 보낼 때 @[Client1]
class DataIn extends Thread {
    Socket socket;

    public DataIn(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        ) {

        } catch (IOException e) {

        }
    }

}
