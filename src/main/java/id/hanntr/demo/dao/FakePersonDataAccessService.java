package id.hanntr.demo.dao;

import id.hanntr.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakePersonDataAccessService implements PersonDao {

    // Define list
    // To add a person, add then to the DB List
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }
}
