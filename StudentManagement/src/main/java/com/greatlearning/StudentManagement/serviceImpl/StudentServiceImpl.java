package com.greatlearning.StudentManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagement.model.Student;
import com.greatlearning.StudentManagement.repository.StudentRepository;
import com.greatlearning.StudentManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {

		return studentRepo.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		studentRepo.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepo.save(student);

	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();

	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepo.deleteById(id);

	}

	@Override
	public List<Student> searchBy(String firstName, String lastName) {
		return studentRepo.findByFirstNameContainsAndLastNameContainsAllIgnoreCase(firstName, lastName);
	}

}
