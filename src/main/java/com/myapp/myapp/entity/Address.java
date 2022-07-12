package com.myapp.myapp.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="Address", schema="spring")
public class Address {
    
    @Id @GeneratedValue(generator="system-uuid")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    UUID id;

    @Column(name="city")
    String city;

    @Column(name="state")
    String state;

    @Column(name = "personId", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    UUID personId;

    public Address() {}

    public Address(String city, String state, UUID personId) {
        this.city = city;
        this.state = state;
        this.personId = personId;
    }
    
    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getPersonId(){
        return personId;
    }

    public void setPersonId(UUID personId){
        this.personId = personId;
    }

    
}
