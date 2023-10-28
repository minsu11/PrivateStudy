package parkminsu.privatestudy.thread.synchronization.exam5;

import java.util.concurrent.ThreadLocalRandom;

public class Sender implements Runnable {
    Data data;

    public Sender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        String[] stringData = {
                "가나다", "가나", "가"
        };
        for (String packet : stringData) {
            data.send(packet);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
    }
}
