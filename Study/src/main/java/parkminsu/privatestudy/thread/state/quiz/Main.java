package parkminsu.privatestudy.thread.state.quiz;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter counter1 = new RunnableCounter("counter1", 10);
        RunnableCounter counter2 = new RunnableCounter("counter2", 10);
        counter1.start();
        counter2.start();
        counter1.join();
        counter2.join();
        System.out.println(counter1.getThread().getName() + " " + counter1.getThread().getState());
        System.out.println(counter2.getThread().getName() + " " + counter2.getThread().getState());
        System.out.println("All threads stopped");
    }
}
