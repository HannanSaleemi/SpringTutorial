package id.hanntr.demo.api;

import id.hanntr.demo.model.Person;
import id.hanntr.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Make REST Resource
@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Add a method that adds a person
    // Set POST
    @PostMapping
    // Take the Request Body and put the information in Person
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    // Retrieve people
    // GET Request
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
}
