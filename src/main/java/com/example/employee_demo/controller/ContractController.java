package com.example.employee_demo.controller;

import com.example.employee_demo.models.Contract;
import com.example.employee_demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @PostMapping(path="/add")
    public @ResponseBody Contract addNewContract (@RequestBody Contract contract) {

        return contractService.save(contract);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Contract> getContract() {
        return contractService.findAll();
    }
}