package parkminsu.privatestudy.socket.quiz.quiz13;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) {
        int port = 1234;
        try {
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.out.println("포트번호를 잘못 입력하셨습니다");
        }

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("대기중");
                Socket socket = serverSocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String idData = br.readLine();
                System.out.println(idData);
                Thread thread = new Thread(new ChatServerThread(socket, idData), idData);


            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

class ChatServerThread implements Runnable {
    static List<ChatServerThread> list = new ArrayList<>();
    static List<String> idList = new ArrayList<>();
    Socket socket;
    String name;
    BufferedWriter bufferedWriter;

    public ChatServerThread(Socket socket, String name) {
        this.name = name;
        this.socket = socket;
        list.add(this);

    }

    private void send(String message) throws IOException {
        this.bufferedWriter.write(message);
        this.bufferedWriter.flush();
    }


    @Override
    public void run() {
        try (BufferedReader socketIn = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             BufferedWriter socketOut = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()))
        ) {
            this.bufferedWriter = socketOut;
            String data = socketIn.readLine();
            idList.add(data);
            int i = 0;
            for (ChatServerThread th : list) {
                th.send(idList.get(i));
                i++;
            }
            while (!Thread.currentThread().isInterrupted()) {
                data = socketIn.readLine();


                for (ChatServerThread th : list) {
                    th.send(data);
                }
            }

        } catch (IOException e) {
            System.out.println("");
        }

    }
}
