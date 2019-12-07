package id.hanntr.demo.service;

import id.hanntr.demo.dao.PersonDao;
import id.hanntr.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Set as service - Spring
@Service
public class PersonService {

    private final PersonDao personDao;

    // Inject - Autowiring into the interface PersonDao
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    // To retieve all people
    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    // Select person by id
    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    // Delete person by id
    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    // Update by ID
    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }

}
