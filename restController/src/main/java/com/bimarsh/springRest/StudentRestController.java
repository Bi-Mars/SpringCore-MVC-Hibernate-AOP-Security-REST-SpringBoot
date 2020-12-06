package com.bimarsh.springRest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bimarsh.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	//define endpoint for "/students" - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student("Bimarsh", "Sharma"));
		students.add(new Student("Timmy", "Trumpet"));
		students.add(new Student("Marshall", "Mathers"));		
		
		return students;
	}
}
