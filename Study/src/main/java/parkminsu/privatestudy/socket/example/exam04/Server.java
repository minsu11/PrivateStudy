package parkminsu.privatestudy.socket.example.exam04;

public class Server {

    public static void main(String[] args) {
        ServerThread serverThread = new ServerThread();
        serverThread.run();

    }
}
