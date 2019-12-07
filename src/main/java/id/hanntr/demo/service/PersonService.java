package id.hanntr.demo.service;

import id.hanntr.demo.dao.PersonDao;
import id.hanntr.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

}
