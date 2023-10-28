package parkminsu.privatestudy.thread.state.exam03;


public class SharedCounter extends Thread {
    private int count;
    private int maxCount;
    private final SharedCount sharedCount;
    private Thread thread;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        setName(name);
        this.maxCount = maxCount;
        this.sharedCount = sharedCount;
        this.count = 0;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
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
