package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entities.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
