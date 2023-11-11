package parkminsu.privatestudy.socket.quiz.quiz10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
    public static void main(String[] args) {
        int port = 1234;

        try {

            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.err.println("잘못된 형식입니다.");
        }
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
                BufferedOutputStream socketOut = new BufferedOutputStream(socket.getOutputStream());
                dataTransfer(socket);
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("");
        }
    }

    public static void dataTransfer(Socket socket) throws IOException {
        BufferedInputStream socketIn = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream socketOut = new BufferedOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[2048];
        int length;
        String bufferString;
        while ((length = socketIn.read(buffer)) > 0) {
            bufferString = new String(buffer, StandardCharsets.UTF_8); // client가 보낸 데이터를 받음
            System.out.println("클라이언트가 보낸 데이터 : " + bufferString);

            socketOut.write(buffer, 0, length);
            socketOut.flush();
        }
    }

}
