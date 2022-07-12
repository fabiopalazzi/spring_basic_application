package com.myapp.myapp.repo;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.entity.AddressReader;

@Repository
@Qualifier(value="AddressViewerRepo")
public interface AddressViewerRepo extends JpaRepository<AddressReader, UUID>{
    @Query("SELECT new com.myapp.myapp.entity.AddressReader(id, city, state, personId) FROM Address WHERE personId = :personId")
    List<AddressReader> getAddressOfPerson(@Param("personId") UUID personId);
       
    @Query(value = "SELECT new com.myapp.myapp.entity.AddressReader(id, city, state, personId) FROM Address")
    List<AddressReader> getAllAddress();
}