package id.hanntr.demo.dao;

import id.hanntr.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    // Insert person with an ID
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        // Generate the random UUID
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    // Return all people
    List<Person> selectAllPeople();

    // Select person by Id
    Optional<Person> selectPersonById(UUID id);

    // Delete a person
    int deletePersonById(UUID id);

    // Update a person
    int updatePersonById(UUID id, Person person);


}
