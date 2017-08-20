package ir.parsova.service;

import ir.parsova.domain.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {


    private List<Person> persons = new ArrayList<>(
            Arrays.asList(
                    new Person("1", "mahbod", "kh"),
                    new Person("2", "ali", "mahmoudi"),
                    new Person("3", "reza", "irajy")
            ));

    public List<Person> findAll() {
        return persons;
    }

    public Person findPerson(String id) {
        return persons.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }


    public void updatePerson(String id) {
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            if (person.getId().equals(id)) {
                persons.set(i, person);
                return;
            }
        }
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void deletePerson(String id) {
        persons.removeIf(p -> p.getId().equals(id));
    }
}
