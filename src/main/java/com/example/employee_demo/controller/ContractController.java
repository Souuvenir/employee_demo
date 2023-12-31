package com.example.employee_demo.controller;

import com.example.employee_demo.models.Contract;
import com.example.employee_demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( value = "http://localhost:3000")
@Controller
@RequestMapping(path="/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    public ContractController(ContractService contractService) {

        this.contractService = contractService;
    }

    @PostMapping(path="/add")
    public @ResponseBody Contract addNewContract (@RequestBody Contract contract) {

        return contractService.save(contract);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Contract> getContract() {
        return contractService.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Integer id) {
        contractService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
