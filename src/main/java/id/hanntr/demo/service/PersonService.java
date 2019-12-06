package id.hanntr.demo.service;

import id.hanntr.demo.dao.PersonDao;
import id.hanntr.demo.model.Person;

public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

}
