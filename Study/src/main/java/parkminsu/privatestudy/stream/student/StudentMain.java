package parkminsu.privatestudy.stream.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Student("p", (int) (Math.random() * 100 + 1)));
        }
        list.stream()
                .filter(num -> num.getScore() >= 70)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .mapToInt(num -> num.getScore())
                .forEach(System.out::println);
        list.stream()
                .sorted(Comparator.comparing(Student::getScore))
                .map(str -> str.getName() + ": " + str.getScore())
                .forEach(System.out::println);
        int max = list.stream()
                .filter(num -> num.getScore() >= 70)
                .mapToInt(num -> num.getScore()).max().orElse(0);
        System.out.println("최댓값:" + max);

        double sum = list.stream()
                .mapToInt(Student::getScore)
                .average().orElse(0);
        System.out.println(sum);
    }
}
