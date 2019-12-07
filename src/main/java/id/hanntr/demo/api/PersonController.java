package id.hanntr.demo.api;

import id.hanntr.demo.model.Person;
import id.hanntr.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    // POST request - /api/v1/person
    @PostMapping
    // Take the Request Body and put the information in Person
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    // Retrieve people
    // GET Request /api/v1/person
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    // Get person by specified ID - If not then null (Can change to custom message as necessary)
    // GET - /api/v1/person/{id} - Get ID from URL - Using @PathVariable
    // We say that get ID from URL - and turn it into a UUID
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    // Delete person by ID
    // DELETE Request
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    
}
