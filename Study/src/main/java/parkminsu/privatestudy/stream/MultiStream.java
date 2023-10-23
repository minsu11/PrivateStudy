package parkminsu.privatestudy.stream;

import java.util.Arrays;
import java.util.List;

public class MultiStream {
    public static void main(String[] args) {
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        int sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;
        System.out.println(sum);
    }
}
