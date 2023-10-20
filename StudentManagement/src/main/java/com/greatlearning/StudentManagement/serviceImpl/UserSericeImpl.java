package com.greatlearning.StudentManagement.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagement.dto.UserDto;
import com.greatlearning.StudentManagement.model.Role;
import com.greatlearning.StudentManagement.model.User;
import com.greatlearning.StudentManagement.repository.RoleRepository;
import com.greatlearning.StudentManagement.repository.UserRepository;
import com.greatlearning.StudentManagement.service.UserService;

@Service
public class UserSericeImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleRepository.findByName("ROLE_USER");
		if (role == null) {
			Role userRole = new Role();
			userRole.setName("ROLE_USER");
			role = roleRepository.save(userRole);
		}
		user.setRoles(List.of(role));
		userRepository.save(user);

	}

	@Override
	public User findUserByUserName(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public List<UserDto> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map((user) -> mapToUserDto(user)).collect(Collectors.toList());
	}

	private UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		return userDto;
	}

}
