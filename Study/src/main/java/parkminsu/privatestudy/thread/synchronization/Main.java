package parkminsu.privatestudy.thread.synchronization;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedCount sharedCount = new SharedCount();
        SharedCount sharedCount1 = new SharedCount();
        SharedCounter sharedCounter1 = new SharedCounter("counter1", 10000, sharedCount);
        SharedCounter sharedCounter2 = new SharedCounter("counter2", 10000, sharedCount);

        SharedCounter sharedCounter3 = new SharedCounter("counter3", 10000, sharedCount1);
        sharedCounter1.start();
        sharedCounter2.start();
        System.out.println(sharedCounter1.getName() + ": started");
        System.out.println(sharedCounter2.getName() + ": started");

        sharedCounter1.join();
        sharedCounter2.join();
        System.out.println(sharedCounter1.getName() + ": terminated");
        System.out.println(sharedCounter2.getName() + ": terminated");

        System.out.println("sharedcount: " + sharedCount.getCount());

    }
}
