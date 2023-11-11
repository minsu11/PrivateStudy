package parkminsu.privatestudy.socket.example.exam04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.hashCode());
        list.add(1);
        System.out.println(list.hashCode());

        as(list);
        System.out.println(list.hashCode());

    }

    public static void as(List<Integer> integers) {
        List<Integer> zxc = new ArrayList<>();
        zxc.add(2);
        integers = zxc;
        System.out.println(zxc.hashCode());
        System.out.println(integers.hashCode());
    }
}
