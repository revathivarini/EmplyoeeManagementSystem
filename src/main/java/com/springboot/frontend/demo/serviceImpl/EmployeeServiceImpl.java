package com.springboot.frontend.demo.serviceImpl;

import com.springboot.frontend.demo.entity.Employee;
import com.springboot.frontend.demo.repository.EmployeeRepository;
import com.springboot.frontend.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setRank(getRank(employee.getFirstName(), employee.getAddress()));

        return employeeRepository.save(employee);
    }

    private int getRank(String name, String address) {
        if (address == null || address.equals("")) {
            return  10;
        }
        String[] patterns = {"^[A-Ha-h].*$", "^[I-Qi-q].*$", "^[R-Zr-z].*$"};
        for (int i = 0; i < patterns.length; i++) {
            if (name.matches(patterns[i])) {

                return i + 1;
            }
        }
        return 0;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {

        employeeRepository.deleteById(id);
    }



}

