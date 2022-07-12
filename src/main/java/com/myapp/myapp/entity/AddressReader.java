package com.myapp.myapp.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Address", schema="spring")
public class AddressReader extends Address {
    public AddressReader(UUID id, String city, String state, UUID personId) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.personId = personId;
    }
}
