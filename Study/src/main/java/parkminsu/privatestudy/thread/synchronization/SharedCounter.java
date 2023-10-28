package parkminsu.privatestudy.thread.synchronization;

public class SharedCounter extends Thread {
    private int count;
    private int maxCount;
    private final SharedCount sharedCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        setName(name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        this.count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            count++;
            System.out.println(getName() + ": " + count);
            sharedCount.increment();
        }
    }
}
