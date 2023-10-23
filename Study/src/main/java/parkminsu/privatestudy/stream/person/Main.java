package parkminsu.privatestudy.stream.person;

public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        personRepository.addPerson(new Person("pa", 20));
        personRepository.addPerson(new Person("pas", 21));
        personRepository.addPerson(new Person("paadas", 32));
        personRepository.addPerson(new Person("pawqe", 14));
        personRepository.addPerson(new Person("padsg", 25));
        personRepository.addPerson(new Person("pawqe", 27));
        personRepository.addPerson(new Person("John", 28));
        personRepository.addPerson(new Person("John", 29));
        personRepository.addPerson(new Person("John", 29));

        personRepository.getPersons().stream()
                .filter(person -> person.getAge() >= 30)
                .map(Person::toString)
                .forEach(System.out::println);
        long num = personRepository.getPersons().stream()
                .filter(person -> person.getName().equals("John"))
                .map(Person::toString)
                .count();
        System.out.println("John인 사람 : " + num);


    }
}
