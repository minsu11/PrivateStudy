package parkminsu.privatestudy.thread.threadclass;

public class Main {
    public static void main(String[] args) {
        Counter counter1 = new Counter("counter1", 10); // 인스턴스
        Counter counter2 = new Counter("Counter2", 10); // 인스턴스
        ThreadCounter threadCounter = new ThreadCounter("threadCounter1", 10);
        ThreadCounter threadCounter1 = new ThreadCounter("threadCount2", 10);

        //counter1.run();
        threadCounter.start();
        counter2.run();


        threadCounter1.start();
    }
}
