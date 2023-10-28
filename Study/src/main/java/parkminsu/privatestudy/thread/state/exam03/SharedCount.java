package parkminsu.privatestudy.thread.state.exam03;

public class SharedCount {
    int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
