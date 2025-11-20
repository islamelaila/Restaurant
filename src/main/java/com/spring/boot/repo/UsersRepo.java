package com.spring.boot.repo;

import com.spring.boot.dto.UsersDto;
import com.spring.boot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

     Optional<Users> findByUsername(String username);




}
