package parkminsu.privatestudy.thread.threadclass;

public class Counter {
    private String name;
    private int count;

    /**
     * 생성자에 이름과 최대 횟수를 인수로 받아 초기화
     */
    public Counter(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void run() {
        int currentCnt = 0;
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
                System.out.println(name + " " + ++currentCnt);
                if (currentCnt == this.count) {
                    break;
                }
            } catch (InterruptedException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
