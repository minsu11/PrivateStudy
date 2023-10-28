package parkminsu.privatestudy.thread.synchronization.exam5;

public class Data {
    private boolean transfer = true;
    private String packet;

    public synchronized void send(String packet) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread Interrupted");
            }
        }
        transfer = true;
        String returnPacket = this.packet;
        notifyAll();
        return returnPacket;
    }
}
