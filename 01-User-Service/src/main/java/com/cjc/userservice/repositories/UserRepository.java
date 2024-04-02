package com.cjc.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.userservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
