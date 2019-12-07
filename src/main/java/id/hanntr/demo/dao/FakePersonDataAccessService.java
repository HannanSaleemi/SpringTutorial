package id.hanntr.demo.dao;

import id.hanntr.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// This class needs to be instantiated so it can be injected
// Setting it to use the fakeDao - can change it to `mongo` when we ant to use an actual DB
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {

    // Define list
    // To add a person, add then to the DB List
    private static List<Person> DB = new ArrayList<>();

    // Search DB get person by ID and return the first match (There should only be one since its an ID)
    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    // Implement getting all people - return DB
    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
}
