package parkminsu.privatestudy.thread.threadpool;

public class Worker implements Runnable {
    String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(getName() + " started ");
        try {
            Thread.sleep(1990);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " finished ");
    }
}
