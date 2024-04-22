package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findById(Integer id) {
         Employee emp = employeeRepository.findById(id).get();
         if (emp == null) {
             throw new NotFoundException("Nor Found Employee with id: " + id);
         }
         System.out.println("employee id : " + emp.getId() + " Not found");

         return emp;
    }



    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {

        employeeRepository.deleteById(id);
    }

    @Override
    public Employee update(Employee employee) {
        Optional<Employee> employee1  =employeeRepository.findById(employee.getId());
        Employee employee2 = new Employee(employee.getId(), employee.getName(), employee.getAge(), employee.getSalary());
        return employeeRepository.save(employee2);
    }
}
