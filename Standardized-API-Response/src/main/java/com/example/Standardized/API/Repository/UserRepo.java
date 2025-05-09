package com.example.Standardized.API.Repository;

import com.example.Standardized.API.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	boolean existsByPhoneNo(String phoneNo);

}
