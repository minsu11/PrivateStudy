package parkminsu.privatestudy.stream;

import java.util.ArrayList;
import java.util.List;

public class DataMain {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numList.add((int) (Math.random() * 200));
        }
        int sumNum = numList.stream()
                .mapToInt(numList1 -> numList1.intValue()).sum();
        double average = numList.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
        int max = numList.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
        int min = numList.stream()
                .mapToInt(Integer::intValue)
                .min().orElse(0);
        long cnt = numList.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 != 0)
                .count();
        long cnt2 = numList.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 == 0)
                .count();

        long cnt3 = numList.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 5 == 0).count();

        long cnt4 = numList.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 3 == 0).count();

        System.out.println(sumNum);
        System.out.println(average);
        System.out.println(max);
        System.out.println(min);
        System.out.println(cnt);
        System.out.println(cnt2);
        System.out.println(cnt3);
        System.out.println(cnt4);

    }
}
