package parkminsu.privatestudy.socket.quiz;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Quiz06 {
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
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        }

        try (Socket socket = new Socket(host, port)) {
            System.out.println("서버에 연결했습니다");
            BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedOutputStream = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            String line;

            while ((line = br.readLine()) != null) {
                bufferedOutputStream.write((line + "\n"));
                bufferedOutputStream.flush();

                line = bufferedInputStream.readLine();
                writer.write(line + "\n");
                writer.flush();
            }

        } catch (ConnectException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결할 수 없습니다");
        }
    }
}
