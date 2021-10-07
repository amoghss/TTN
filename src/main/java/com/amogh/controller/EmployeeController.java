package com.amogh.controller;

import com.amogh.bean.Employee;
import com.amogh.exception.EmployeeNotFoundException;
import com.amogh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Answer-1
    @GetMapping("/Home")
    public String helloWorldPrinter()
    {
        return "Welcome to spring boot";
    }

    // Answer-3 Getting the list of employee
    @GetMapping("/GetEmployees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployee();
    }

    // Answer-4 Getting Employee by Id using Path Valriable
    @GetMapping("/GetEmployees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId)
    {
        return employeeService.getEmployeeById(empId);
    }

    // Answer-5 Add a new Employee
    @PostMapping("/AddEmployee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeService.addEmployee(employee);
    }

    // Answer-7 Delete by ID
    @DeleteMapping("/DeleteMapping/{empId}")
    public String deleteByID(@PathVariable int empId)
    {
        return employeeService.deleteById(empId);
    }

    // Answer-8 Update Employee
    @PutMapping("/UpdateEmployee/{empId}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable int empId)
    {
        return employeeService.updateEmployee(employee, empId);
    }
}
