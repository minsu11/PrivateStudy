package parkminsu.privatestudy.thread.state;

import java.util.regex.Pattern;

public class Tick implements Runnable {
    Thread thread;
    static final Pattern nCheckPattern = Pattern.compile("^[0-9]*n$");

    public Tick(String name) {
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    public boolean isCheckN(String str) {
        return nCheckPattern.matcher(str).find();
    }

    @Override
    public void run() {

    }
}
