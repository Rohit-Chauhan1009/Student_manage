package com.greatlearning.StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.StudentManagement.model.Student;
import com.greatlearning.StudentManagement.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/students")
	public String listStudent(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		// save
		studentService.saveStudent(student);
		// redirect to student homepage
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		return "edit_student";
	}

	@PostMapping("/student/update/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

	@GetMapping("/student/search")
	public String searchStudents(@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName, Model model) {
		List<Student> searchResults;
		try {
			if (firstName != null && lastName != null) {
				searchResults = studentService.searchBy(firstName, lastName);
			} else {
				return "redirect:/students";
			}
			model.addAttribute("student", searchResults);
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			return "error";
		}
		return "students";
	}

}
