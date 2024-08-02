package parkminsu.privatestudy.shttp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SHttp {
    public static void main(String[] args){

        int port = 80;
        if(args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        File file = new File("./");
        System.out.println(file.getPath());
        StringBuilder sb = new StringBuilder();
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             ) {
            String str;
            while (true) {
                str = in.readLine();
                if("".equals(str)){
                    break;
                }
                sb.append(str);
            }
            System.out.println(Arrays.toString(sb.toString().getBytes()));
            System.out.println(Arrays.toString("\r\n".getBytes()));

        } catch (IOException e) {

        }
    }
}
