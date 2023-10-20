package com.greatlearning.StudentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagement.model.Student;


public interface StudentService {

	List<Student> getAllStudents();

	public void saveStudent(Student student);

	public void updateStudent(Student student);

	public Student getStudentById(Long id);

	public void deleteStudentById(Long id);

	List<Student> searchBy(String firstName, String lastName);
}
