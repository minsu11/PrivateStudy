package parkminsu.privatestudy.socket.quiz.quiz11;

//public class ServerThread implements Runnable {
//    private final int BUFFER_SIZE = 2048;
//    private Thread thread;
//    private String name;
//    private Socket socket;
//    private static int clientCount = 0;
//
//    public ServerThread(Socket socket) {
//        clientCount = addClientCount(clientCount);
//        this.name = "서버";
//        this.thread = new Thread(name + " " + clientCount);
//        this.socket = socket;
//    }
//
//    private int addClientCount(int client) {
//        client += 1;
//        return client;
//    }
//
//    public void start() {
//        this.thread.start();
//    }
//
//    public void stop() {
//        this.thread.interrupt();
//    }
//
//    public String getName() {
//        return thread.getName();
//    }
//
//    @Override
//    public void run() {
//        try (
//                BufferedInputStream bs = new BufferedInputStream(this.socket.getInputStream());
//                BufferedOutputStream bo = new BufferedOutputStream(this.socket.getOutputStream())
//        ) {
//            byte[] buffer = new byte[BUFFER_SIZE];
//            int length;
//            while ((length = bs.read(buffer)) > 0) {
//                bo.write(buffer, 0, length);
//                bo.flush();
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//}
