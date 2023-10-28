package parkminsu.privatestudy.thread.synchronization;

public class SharedCount {
    private Integer count;
    private final Object LOCK = new Object();

    public SharedCount() {
        count = new Integer(0);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        synchronized (LOCK) {
            setCount(getCount() + 1);
        }
        // 1

    }

    public synchronized static void tset() {
        System.out.println();
    }

}
