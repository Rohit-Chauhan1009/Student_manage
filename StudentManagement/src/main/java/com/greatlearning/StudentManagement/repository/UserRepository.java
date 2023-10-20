package com.greatlearning.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.StudentManagement.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	Boolean existsByUsername(String username);

}
