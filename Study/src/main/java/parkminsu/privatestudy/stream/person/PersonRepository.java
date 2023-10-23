package parkminsu.privatestudy.stream.person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }
}