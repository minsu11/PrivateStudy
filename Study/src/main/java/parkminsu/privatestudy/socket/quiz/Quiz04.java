package parkminsu.privatestudy.socket.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;

public class Quiz04 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;
        String inputData = "";
        if (args.length > 0) {
            host = args[0];
        }
        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.err.println("port에 입력할 수 없는 숫자가 들어왔습니다");
            System.exit(1);
        }

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    inputData = br.readLine();

                    if (inputData.equalsIgnoreCase("exit")) {
                        break;
                    }
                    socket.getOutputStream().write(inputData.getBytes());
                    socket.getOutputStream().write("\n".getBytes());
                    socket.getOutputStream().flush();
                }
            }

        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        }

    }

}
