package com.bimarsh.springRest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		// no need to call because Spring will call @PostConstruct before initializing
		// the bean
		return students;
	}

	// define endpoint for "/students/{studentId}" - return student at index
	@RequestMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// just index into the list ... keeping it simple

		// check the studentId against list size
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student not found - " + studentId);
		}

		return students.get(studentId);
	}

	// add an exception handler using @ExceptionHandler

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		// create a studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add generic exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		
		// create a studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
