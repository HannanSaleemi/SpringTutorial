package id.hanntr.demo.api;

import id.hanntr.demo.model.Person;
import id.hanntr.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Add a method that adds a person
    public void addPerson(Person person) {
        personService.addPerson(person);
    }
}