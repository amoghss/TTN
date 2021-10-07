package com.amogh.service;

import com.amogh.bean.Employee;
import com.amogh.exception.EmployeeNotFoundException;
import com.amogh.persistance.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getAllEmployee()
    {
        return employeeDao.findAll();
    }

    public Employee getEmployeeById(int id) {

        Optional<Employee> emp= employeeDao.findById(id);

        if(!emp.isPresent())
        {
            throw new EmployeeNotFoundException("Employee Id:"+id);
        }
        else
        {
            return emp.get();
        }

    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    public String deleteById(int empId) {

        // Answer-6 Exception Handling for Resource not Found
        try {
            employeeDao.deleteById(empId);
            return "Success";
        }
        catch(EmptyResultDataAccessException e)
        {
            throw new EmployeeNotFoundException("Employee Id:"+empId);
        }
    }

    public String updateEmployee(Employee employee, int empId) {

        if(employeeDao.updateEmployee(employee.getName(), employee.getAge(), empId) == 0)
        {
            throw new EmployeeNotFoundException("Employee Id:"+empId);
        }
        else
        {
            return "Success";
        }
    }
}
