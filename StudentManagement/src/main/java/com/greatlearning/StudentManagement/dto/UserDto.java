package com.greatlearning.StudentManagement.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;

	@NotEmpty
	private String username;

	@NotEmpty
	private String password;
}
