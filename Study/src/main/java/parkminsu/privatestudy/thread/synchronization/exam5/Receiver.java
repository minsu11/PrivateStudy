package parkminsu.privatestudy.thread.synchronization.exam5;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    Data data;
    String receiveData;

    public Receiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (receiveData = data.receive(); !"가".equals(receiveData); receiveData = data.receive()) {
            System.out.println("data: " + receiveData);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
    }
}
