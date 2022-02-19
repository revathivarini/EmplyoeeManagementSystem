package com.springboot.frontend.demo.controllers;

import com.springboot.frontend.demo.entity.Employee;
import com.springboot.frontend.demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller//To make this class Spring mvc to handle requests
public class EmployeeController {

    private EmployeeService employeeService;//injecting service dependency

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //handler method to handle list of employees and return model and view

    @GetMapping("/")
    public String landingPage() {
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String listOfEmployees(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employees";
    }
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model){
        //create employee object to hold employee form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    //Add or create new Employee, it redirects to main page
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }


    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Integer id, Model model){
      model.addAttribute("employee", employeeService.getEmployeeById(id));
      return "edit_employee";
    }

    //Update Employee of existing employees and redirect to main page
    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Integer id,
                                 @ModelAttribute("employee") Employee employee,
                                 Model model){
     //get employee from database by id
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setId(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save updated employee object.
        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    //handler method to delete employee request
    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
      return "redirect:/employees";
    }

}
