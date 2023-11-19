package parkminsu.privatestudy.socket.quiz.quiz12;

import java.io.*;
import java.net.Socket;

public class Client {
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
            System.err.println("포트번호가 잘못 됐습니다");
        }

        try (Socket socket = new Socket(host, port);
        ) {
            System.out.println("서버에 연결되었습니다.");
            ServerIn serverIn = new ServerIn(socket);
            ServerOut serverOut = new ServerOut(socket);
            serverIn.start();
            serverOut.start();
            while (!Thread.currentThread().isInterrupted()) {
                // thread로 ?
                // 하나는 보내기만 하고 하나는 가져오기만 해야하나?
            }
            System.out.println("연결이 끊어졌습니다.");


        } catch (IOException e) {
            System.out.println(host + ":" + port + "에 연결할 수 없습니다");
        }

    }
}

class ServerIn extends Thread {
    Socket socket;

    public ServerIn(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter dataOut = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()))
        ) {
            String data;
            while (!Thread.currentThread().isInterrupted()) {
                data = bufferedReader.readLine();
                dataOut.write(data);
                dataOut.flush();
            }

            this.socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

class ServerOut extends Thread {
    Socket socket;
    private final int BUFFER_SIZE = 2048;

    public ServerOut(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedInputStream socketIn = new BufferedInputStream(this.socket.getInputStream());
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}