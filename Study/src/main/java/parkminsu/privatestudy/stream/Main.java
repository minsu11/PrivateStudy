package parkminsu.privatestudy.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("date", "apple", "apple", "cherry", "banana", "elderberry", "fig", "grape");
        Stream<String> stream = wordList.stream();
        System.out.println(stream.collect(Collectors.toList()).toString());
        wordList.stream().filter(string -> string.length() > 5).forEach(System.out::println);
        wordList.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
        int num = wordList.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
        wordList.stream().filter(str -> str.length() == num).forEach(System.out::println);
        StringBuilder stringBuilder = new StringBuilder();
        wordList.forEach(string -> stringBuilder.append(string).append(", "));
        System.out.println(stringBuilder);
        System.out.println();
        wordList.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.comparing(String::toString).reversed()).forEach(System.out::println);

        System.out.println();
        wordList.stream()
                .sorted().forEach(System.out::println);
        int num2 = wordList.stream()
                .mapToInt(String::length).max().orElse(0);
        wordList.stream()
                .filter(string -> string.length() == num2)
                .forEach(System.out::println);

        StringBuilder stringBuilder1 = new StringBuilder();
        wordList.stream()
                .map(String::toString)
                .forEach(string -> stringBuilder1.append(string).append(";"));
        System.out.println(stringBuilder1);
        wordList.stream().distinct().map(String::toString).forEach(System.out::println);
    }
}
