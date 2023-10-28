package parkminsu.privatestudy.thread.runnableinterface;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter counter = new RunnableCounter("counter", 10);
        RunnableCounter counter1 = new RunnableCounter("counter2", 10);
        Thread thread = new Thread(counter);
        Thread thread1 = new Thread(counter);
        thread.start();
        thread1.start();
        Thread.sleep(3000);
        thread.interrupt();
        // 1. 본인의 자원을 가지고 interrupt를 하기 때문에

    }
}
