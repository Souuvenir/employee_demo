package com.example.employee_demo.controller;

import com.example.employee_demo.models.Employee;
import com.example.employee_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( value = "http://localhost:3000")
@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(path="/add")
    public @ResponseBody Employee addNewUser (@RequestBody Employee employee) {

      return employeeService.save(employee);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Employee> getAllUsers() {

        return employeeService.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

