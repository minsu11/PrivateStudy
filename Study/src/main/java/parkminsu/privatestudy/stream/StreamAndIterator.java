package parkminsu.privatestudy.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAndIterator {
    public static void main(String[] args) {
        List<String> stringDataList = Arrays.asList(
                "banana",
                "grape",
                "fig",
                "elderberry",
                "apple",
                "cherry",
                "date",
                "honeydew",
                "ap"
        );
        stringDataList.stream()
                .filter(str -> str.length() >= 5)
                .map(String::toString)
                .forEach(System.out::println);
        System.out.println();
        stringDataList.stream()
                .map(String::toUpperCase)
                .map(String::toString)
                .forEach(System.out::println);
        List<String> sortList = stringDataList.stream()
                .sorted().collect(Collectors.toList());
        System.out.println(sortList.toString());

        Iterator<String> iterator = stringDataList.stream()
                .sorted(Comparator.comparing(String::toString).reversed())
                .iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=======");
        int cnt = stringDataList.stream()
                .filter(string -> string.length() % 2 != 0)
                .iterator().next().length();
        System.out.println(cnt);

        System.out.println(stringDataList.stream()
                .filter(string -> string.length() % 2 == 0)
                .filter(string -> string.charAt(0) == 'a'
                        || string.charAt(0) == 'e'
                        || string.charAt(0) == 'i'
                        || string.charAt(0) == 'o'
                        || string.charAt(0) == 'u').count());
    }
}
