package parkminsu.privatestudy.socket.quiz.quiz09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
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
            System.err.println("포트 번호가 잘못됐습니다");
        }

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();
            BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream socketOut = new BufferedOutputStream(socket.getOutputStream());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            System.out.println("클라이언트가 접속했습니다.");
            String string;
            byte[] buffer = new byte[2048];
            int length;
            System.out.println(socket.getRemoteSocketAddress());
            while ((length = socketIn.read(buffer)) > 0) {
                string = new String(buffer, StandardCharsets.UTF_8);
                System.out.println(string);
                socketOut.write(buffer, 0, length);
                socketOut.flush();
            }
            socket.close();
        } catch (IOException e) {
            System.err.println(host + ":" + port + "에 연결이 안됩니다.");
        }
    }
}
