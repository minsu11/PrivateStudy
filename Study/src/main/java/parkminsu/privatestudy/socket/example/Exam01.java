package parkminsu.privatestudy.socket.example;

import java.io.IOException;
import java.net.Socket;

public class Exam01 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("서버에 연결 되었습니다.");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
