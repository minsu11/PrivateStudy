package parkminsu.privatestudy.thread.runnableinterface;

import java.util.concurrent.atomic.AtomicBoolean;

public class RunnableCounter implements Runnable {
    private String name;
    private int count;
    final AtomicBoolean isRunning = new AtomicBoolean(false);
    //boolean isRunning = false;
    private AtomicBoolean stopped = new AtomicBoolean(false); // 동시성 제어
    // 동시성 제어를 쓴다?
    Thread thread;

    public RunnableCounter(String name, int count) {
        this.name = name;
        thread = new Thread(name);
        this.count = count;
    }

    public void start() {
        thread.start();
    }

    boolean isRunning() {
        return isRunning.get();
    }

    void isStopped() {
        isRunning.set(false);
    }

    @Override
    public void run() {
        int cnt = 0;
        isRunning.set(true);
        try {
            while (cnt < this.count && isRunning.get()) {

                cnt++;
                System.out.println(this.name + ": " + cnt);

                Thread.sleep(1000);

            }
        } catch (InterruptedException ignore) {
            Thread.currentThread().interrupt();
        }
        stopped.set(true);
    }

}
