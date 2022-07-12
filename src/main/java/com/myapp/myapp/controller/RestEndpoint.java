package com.myapp.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.myapp.entity.Address;
import com.myapp.myapp.entity.AddressReader;
import com.myapp.myapp.entity.Person;
import com.myapp.myapp.service.impl.GeneralService;

@RestController
public class RestEndpoint {

    @Value("${default.person.name}")
    private String defaultName;

    @Value("${default.person.surname}")
    private String defaultSurname;

    @Value("${default.person.age}")
    private String defaultAge;

    @Autowired
    private GeneralService service;

    @RequestMapping(path = "/defaultPerson", method = RequestMethod.GET)
    public Person getPerson(){
        return new Person(defaultName, defaultSurname, Integer.parseInt(defaultAge));
    }

    @RequestMapping(path = "/person", method = RequestMethod.POST)
    public Person setPerson(@RequestBody Person person) {
        return new Person(person.getName(), person.getSurname(), person.getAge());
    }

    // http://localhost:8080/rest/hello?name=John
    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public Person getPerson(@RequestParam(value="name", defaultValue="ds", required=false) String name, 
                            @RequestParam(value="surname", defaultValue="ds", required=true) String surname, 
                            @RequestParam(value="age", defaultValue="23", required=true) String age) {
        return new Person(name, surname, Integer.parseInt(age));
    }

    @RequestMapping(path="/getAllPerson", method = RequestMethod.GET)
    public List<Person> getAllPerson(){
        return service.getAllPerson();
    }

    @RequestMapping(path="/addPerson", method = RequestMethod.POST)
    public Person addPerson(@RequestBody Person person){
        return service.addPerson(person);
    }

    @RequestMapping(path="/getAllAddress", method=RequestMethod.GET)
    public List<AddressReader> getAllAddresses(){
        return service.getAllAddress();
    }

    @RequestMapping(path="/addAddress", method = RequestMethod.POST)
    public Address addAddress(@RequestBody Address address){
        return service.addAddressToUser(address);
    }

    @RequestMapping(path="/getAddressOfPerson", method=RequestMethod.GET)
    public List<AddressReader> addressPerson(@RequestParam("id") String id){
        return service.getAddressOfPerson(id);
    }

}
