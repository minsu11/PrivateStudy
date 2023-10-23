package parkminsu.privatestudy.thread;

public class ThreadCounter extends Thread {
    private String name;
    private int count;

    public ThreadCounter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void run() {
        int cnt = 0;
        while (!Thread.interrupted()) { // true
            try {
                Thread.sleep(1000);
                cnt++;
                System.out.println(this.name + " " + cnt);

                if (cnt == this.count) {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
