package com.springboot.frontend.demo;

import com.springboot.frontend.demo.entity.Employee;
import com.springboot.frontend.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontendEmployeeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FrontendEmployeeApplication.class, args);
	}
//	@Autowired
//	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee emp1 = new Employee("Ravi", "Avula", "ravi.avula@gmail.com");
//		employeeRepository.save(emp1);
//		Employee emp2 = new Employee("Revathi", "Varini", "reva.avula@gmail.com");
//		employeeRepository.save(emp2);
//		Employee emp3 = new Employee("Bhagya", "avula", "bha.avula@gmail.com");
//		employeeRepository.save(emp3);
//		Employee emp4= new Employee("Samya", "A", "sam.avula@gmail.com");
//		employeeRepository.save(emp4);
	}
}
