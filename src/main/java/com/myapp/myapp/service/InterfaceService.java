package com.myapp.myapp.service;

import java.util.List;

import com.myapp.myapp.entity.Address;
import com.myapp.myapp.entity.AddressReader;
import com.myapp.myapp.entity.Person;

public interface InterfaceService {

    //get all person in database
    List<Person> getAllPerson();

    //add person to database
    Person addPerson(Person p);

    //get all address
    List<AddressReader> getAllAddress();

    //add address to user
    Address addAddressToUser(Address address);

    List<AddressReader> getAddressOfPerson(String id);
}
