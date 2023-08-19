package com.example.employee_demo.controller;

import com.example.employee_demo.models.EmployeeModel;
import com.example.employee_demo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody EmployeeModel employee) {

      return employeeService.save(employee);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<EmployeeModel> getAllUsers() {
        // This returns a JSON or XML with the users
        return employeeService.findAll();
    }
}

