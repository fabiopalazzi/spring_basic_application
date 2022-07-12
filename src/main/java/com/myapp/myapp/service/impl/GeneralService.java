package com.myapp.myapp.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.myapp.entity.Address;
import com.myapp.myapp.entity.AddressReader;
import com.myapp.myapp.entity.Person;
import com.myapp.myapp.service.InterfaceService;
import com.myapp.myapp.repo.AddressRepo;
import com.myapp.myapp.repo.AddressViewerRepo;
import com.myapp.myapp.repo.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class GeneralService implements InterfaceService{

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private AddressViewerRepo addViewRepo;

    @Override
    public List<Person> getAllPerson() {
        return personRepo.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public List<AddressReader> getAllAddress() {
        return addViewRepo.getAllAddress();
    }

    @Override
    public Address addAddressToUser(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public List<AddressReader> getAddressOfPerson(String id){
        return addViewRepo.getAddressOfPerson(UUID.fromString(id));
    }
    
}
