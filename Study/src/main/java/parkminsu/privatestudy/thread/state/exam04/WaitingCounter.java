package parkminsu.privatestudy.thread.state.exam04;

public class WaitingCounter implements Runnable {
    RunnableCounter runnableCounter;
    Thread thread;

    public WaitingCounter(RunnableCounter runnableCounter) {
        this.runnableCounter = runnableCounter;
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    @Override
    public void run() {
        try {
            System.out.println(runnableCounter.getThread().getState());
            runnableCounter.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
