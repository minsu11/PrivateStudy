package parkminsu.privatestudy.thread.state.exam04;

public class RunnableCounter implements Runnable {
    private int maxCount;
    private Thread thread;

    public RunnableCounter(String name, int count) {
        this.maxCount = count;
        this.thread = new Thread(this);
        thread.setName(name);
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    @Override
    public void run() {
        int cnt = 0;
        while (cnt < maxCount) {
            try {
                cnt++;
                System.out.println(cnt);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
