package com.myapp.myapp.repo;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.entity.Address;

@Repository
@Qualifier(value="AddressRepo")
public interface AddressRepo extends JpaRepository<Address, UUID> {
}
