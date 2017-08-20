package ir.parsova.controller;

import ir.parsova.service.PersonService;
import ir.parsova.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    @RequestMapping("/person/{id}")
    public Person findPerson(@PathVariable String id) {
        return personService.findPerson(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/persons")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/person/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable String id) {
        personService.updatePerson(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/person/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }


}
