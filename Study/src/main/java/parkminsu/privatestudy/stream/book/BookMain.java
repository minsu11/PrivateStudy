package parkminsu.privatestudy.stream.book;

import static java.util.stream.Collectors.counting;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookMain {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = SECURE_RANDOM.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            bookList.add(
                    new Book(generateRandomString(5),
                            generateRandomString(5),
                            (int) (Math.random() * 1000),
                            (Math.random() * 100))
            );
        }
        bookList.stream()
                .filter(book -> book.getPrice() >= 50)
                .map(Book::toString)
                .forEach(System.out::println);
        bookList.add(new Book("asdads", "J.K. Rowling", 1000, 50000));
        bookList.add(new Book("asdadserqw", "J.K. Rowling", 1023, 40000));
        bookList.add(new Book("asdadsasd", "J.K. Rowling", 1052, 30000));
        bookList.add(new Book("asdads213", "J.K. Rowling", 1100, 20000));
        int num = bookList.stream()
                .filter(book -> book.getAuthor().equals("J.K. Rowling"))
                .mapToInt(Book::getYear).min().orElse(0);

        bookList.stream()
                .filter(book -> book.getAuthor().equals("J.K. Rowling"))
                .filter(book -> book.getYear() == num)
                .map(Book::toString)
                .forEach(System.out::println);

        double price = bookList.stream()
                .mapToDouble(Book::getPrice)
                .max()
                .orElse(0);
        System.out.println(price);
        System.out.println();
        
        bookList.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .map(Book::toString)
                .forEach(System.out::println);

        List<Book> list2 = bookList.stream()
                .map(book -> new Book(book.getTitle(), book.getAuthor(), book.getYear(), (book.getPrice()) - book.getPrice() / 10))
                .collect(Collectors.toList());

        list2.stream()
                .map(Book::toString)
                .forEach(System.out::println);

        Map<String, Long> st = bookList.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, counting()));

        System.out.println(st.toString());

        List<Book> books = bookList.stream()
                .filter(book -> book.getPrice() < 30)
                .map(book -> new Book(book.getTitle(), book.getAuthor(), book.getYear(), book.getPrice() + book.getPrice() / 20))
                .collect(Collectors.toList());
        books.stream()
                .map(Book::toString).forEach(System.out::println);
    }
}
