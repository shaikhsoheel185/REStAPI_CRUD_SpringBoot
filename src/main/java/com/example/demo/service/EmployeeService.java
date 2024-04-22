package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface EmployeeService {


    public Employee findById(Integer id);

    public Employee save(Employee employee);
    public void deleteById(Integer id);
    public Employee update(Employee employee);

}
