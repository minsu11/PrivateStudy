package parkminsu.privatestudy.monte;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MonteCarlo {
    public static void main(String[] args) {
        int count = 0;
        double size = 10_0000.0;
        List<Pointer> random = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            random.add(new Pointer(Math.random(), Math.random())); // x,y
        }
        Iterator<Pointer> ip = random.iterator();
        while (ip.hasNext()) {
            Pointer pointer = ip.next();
            if (Math.pow(pointer.x, 2) + Math.pow(pointer.y, 2) <= 1) {
                count++;
            }
        }
        System.out.println(count / size * 4);
    }
}

