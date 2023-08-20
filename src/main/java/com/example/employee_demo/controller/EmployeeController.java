package com.example.employee_demo.controller;

import com.example.employee_demo.models.Employee;
import com.example.employee_demo.controller.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody Employee addNewUser (@RequestBody Employee employee) {

      return employeeService.save(employee);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Employee> getAllUsers() {
        // This returns a JSON or XML with the users
        return employeeService.findAll();
    }
}

