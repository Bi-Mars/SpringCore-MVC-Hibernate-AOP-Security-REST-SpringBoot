package com.bimarsh.springRest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bimarsh.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// define @PostConstruct to load the student data... only once!
	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();

		students.add(new Student("Bimarsh", "Sharma"));
		students.add(new Student("Timmy", "Trumpet"));
		students.add(new Student("Marshall", "Mathers"));
	}

	// define endpoint for "/students" - return list of students

	@GetMapping("/students")
	public List<Student> getStudent() {
		//no need to call because Spring will call @PostConstruct before initializing the bean
		return students;
	}
	
	//define endpoint for "/students/{studentId}" - return student at index
	@RequestMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//just index into the list ... keeping it simple
		
		return students.get(studentId);
	}
}
