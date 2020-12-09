package com.bimarsh.springboot.employee.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.bimarsh.springboot.restcrudspringboot.RestCrudSpringbootApplication;
import com.bimarsh.springboot.restcrudspringboot.dao.EmployeeRepository;
import com.bimarsh.springboot.restcrudspringboot.entity.Employee;
import com.bimarsh.springboot.restcrudspringboot.rest.EmployeeRestController;
import com.fasterxml.jackson.databind.ObjectMapper;

//specify name of the controller
@WebMvcTest(EmployeeRestController.class) 
@SpringBootTest(
    classes = RestCrudSpringbootApplication.class,
    webEnvironment = WebEnvironment.RANDOM_PORT
)
public class EmployeeRestControllerTest {

	@Autowired 
	private MockMvc mockMvc; // perform request 
	
	//Convert Object to JSON and vice-versa
	@Autowired
	private ObjectMapper objectMapper;
	
	//Rest controller depends on EmployeeService, so mock Repository --> DAO
	@MockBean
	private EmployeeRepository employeeRepo;
	
	//write Test Method --> Test REST controller that returns List of Employee
	@Test
	public void testListEmployee() throws Exception {
		List<Employee> listEmployee = new ArrayList<>();
		//mock data
		listEmployee.add(new Employee("Leslie", "Andrews", "leslie@luv2code.com"));
		listEmployee.add(new Employee("Timmy", "Trumpet", "timmyTrumpet101@gmail.com"));
		listEmployee.add(new Employee("Yuri", "Petrov", "yuri@luv2code.com"));
		listEmployee.add(new Employee("Juan", "Vega", "juan@luv2code.com"));
		listEmployee.add(new Employee("Bimarsh", "Sharma", "bimarshsharma101@gmail.com"));

		// Mock the data returned
		Mockito.when(employeeRepo.findAll()).thenReturn(listEmployee);
		
		//endPoint
		String endPoint="/employees/";
		
		//get the response
		MvcResult mvcResult = mockMvc.perform(get(endPoint))
			   .andExpect(status().isOk())
			   .andReturn();		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		
		//ObjectMapper to convert JSON to Object
		
		String expectedJsonResponse = objectMapper.writeValueAsString(listEmployee);
		
		assertEquals(actualJsonResponse, expectedJsonResponse);;
		
		}
	
	
	
}
