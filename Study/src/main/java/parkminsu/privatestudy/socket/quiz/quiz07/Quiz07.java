package parkminsu.privatestudy.socket.quiz.quiz07;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

/**
 * 요구 사항
 * Quiz-06에서는 입력된 문자열을 전송하고, 이를 돌려 받은 후 다음 문자열을 보낼 수 있다.
 * <p>
 * 본 프로그램에서는 보낸 과정과 받는 과정을 분리하여 개별 동작이 가능하도록 수정한다.
 * <p>
 * 두 동작의 개별 동작은 thread를 이용해 구현 가능하다.
 */
public class Quiz07 {
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
            System.err.println("값을 잘못 읿력하셨습니다");
        }
        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결되었습니다.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // console에서 데이터입력
            BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out)); // console

            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            Receive receiver = new Receive("socketIn", socketIn, wt);
            Sender sender = new Sender("send", br, socketOut);

            receiver.start();
            sender.start();
            while (!receiver.getThread().isInterrupted()) {
                try {
                    String data = br.readLine();
                    if (data.equals("exit")) {
                        break;
                    }
                    socketOut.write(data + "\n");
                    socketOut.flush();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 앖습니다");
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        }

    }
}
