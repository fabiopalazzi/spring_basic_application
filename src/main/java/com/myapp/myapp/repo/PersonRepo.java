package com.myapp.myapp.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.entity.Person;

@Repository
@Qualifier(value="PersonRepo")
public interface PersonRepo extends JpaRepository<Person, String>{
}
