package com.springboot.frontend.demo.repository;

import com.springboot.frontend.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository //No need to define this annotation
//JPARepo interface automatically implements @Repository.
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
