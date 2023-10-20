package com.greatlearning.StudentManagement.service;

import java.util.List;

import com.greatlearning.StudentManagement.dto.UserDto;
import com.greatlearning.StudentManagement.model.User;

public interface UserService {

	void saveUser(UserDto userDto);

	User findUserByUserName(String username);

	List<UserDto> findAllUsers();

}
