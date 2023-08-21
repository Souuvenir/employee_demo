package com.example.employee_demo.controller;

import com.example.employee_demo.models.Employee;
import com.example.employee_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
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

    @DeleteMapping(path="/delete")
    public ResponseEntity<Void> deleteArea(@RequestBody Employee employee) {
        employeeService.deleteById(employee.getId());
        return ResponseEntity.ok().build();
    }
}

