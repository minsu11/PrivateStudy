package parkminsu.privatestudy.socket.quiz;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Quiz03 {
    public static void main(String[] args) throws UnknownHostException {
        try {
            if (args.length == 0) {
                socketInformation("localhost", 1234);
            } else if (args.length == 1) {
                socketInformation(InetAddress.getByName(args[0]), 1234);
            } else if (args.length == 2) {
                socketInformation(args[0], Integer.valueOf(args[1]));
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("args에 값을 넣지 않았습니다");
        }

    }

    public static void socketInformation(String domainName, int port) {
        try (Socket socket = new Socket(domainName, port)) {
            System.out.println("서버에 연결되었습니다");
            System.out.println("Local address : " + socket.getLocalSocketAddress());
            System.out.println("Local port: " + socket.getLocalPort());
            System.out.println("Remote address: " + socket.getRemoteSocketAddress());
            System.out.println("Remote port: " + socket.getPort());
        } catch (IOException e) {
            System.out.println(domainName + ":" + port + "에 연결할 수 없습니다.");
        }
    }

    public static void socketInformation(InetAddress domainName, int port) {
        try (Socket socket = new Socket(domainName, port)) {
            System.out.println("서버에 연결되었습니다");
            System.out.println("Local address : " + socket.getLocalSocketAddress());
            System.out.println("Local port: " + socket.getLocalPort());
            System.out.println("Remote address: " + socket.getRemoteSocketAddress());
            System.out.println("Remote port: " + socket.getPort());
        } catch (IOException e) {
            System.out.println(domainName + ":" + port + "에 연결할 수 없습니다.");
        }
    }


}
