package parkminsu.privatestudy.socket.quiz;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Quiz05 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 3222;
        if (args.length > 0) {
            host = args[0];
        }
        try {
            if (args.length > 1) {
                port = Integer.parseInt(args[1]);
            }
        } catch (NumberFormatException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다.");
        }

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 접속했습니다.");
            // end::getInputStream[]
            // tag::getOutputStream[]
            // end::getOutputStream[]
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            int readLength;
            // tag::createBuffer[]
            // end::createBuffer[]
            try (BufferedReader br = new BufferedReader(new InputStreamReader(bufferedInputStream))) {
                // tag::inputRead[]
                while (true) {
                    String data = "";

                    data = br.readLine();

                    // end::inputRead[]
                    if (data.trim().equalsIgnoreCase("exit")) {
                        break;
                    }
                    System.out.println(data);

                }
            }

        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        }

    }
}
