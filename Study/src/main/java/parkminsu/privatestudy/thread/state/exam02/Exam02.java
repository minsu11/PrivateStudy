package parkminsu.privatestudy.thread.state.exam02;

public class Exam02 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter runnableCounter = new RunnableCounter("counter", 5);
        runnableCounter.start();
        System.out.println(runnableCounter.getThread().getState());
    }
}
