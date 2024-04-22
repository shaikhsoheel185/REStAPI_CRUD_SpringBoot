package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class controller {


    EmployeeService employeeService;


    @Autowired
    public controller(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/v1/getemployee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @PostMapping("/v1/saveemployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

        return ResponseEntity.ok().body(employeeService.save(employee));
    }


    @DeleteMapping("/v1/delete/{id}")
    public  ResponseEntity<String>  deleteEmployee( @PathVariable ("id") int id) {

        employeeService.deleteById(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }

    @GetMapping("/v1/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.update(employee));
    }

}
