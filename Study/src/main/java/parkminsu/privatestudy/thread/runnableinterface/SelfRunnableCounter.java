package parkminsu.privatestudy.thread.runnableinterface;

public class SelfRunnableCounter implements Runnable {
    private int count;
    private int maxCount;
    private Thread thread;

    public SelfRunnableCounter(String name, int maxCount) {
        this.count = 0;
        this.maxCount = maxCount;
        this.thread = new Thread(this, name);
    }

    public void start() {
        thread.start();

    }

    @Override
    public void run() {
        while (count < maxCount) {
            try {
                ++count;
                System.out.println(thread.getName() + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
