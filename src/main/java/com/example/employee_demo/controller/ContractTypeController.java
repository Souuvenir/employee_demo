package com.example.employee_demo.controller;

import com.example.employee_demo.models.ContractType;
import com.example.employee_demo.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( value = "http://localhost:3000")
@Controller
@RequestMapping(path="/contract-type")
public class ContractTypeController {
    @Autowired
    ContractTypeService contractTypeService;

    public ContractTypeController(ContractTypeService contractTypeService) {

        this.contractTypeService = contractTypeService;
    }

    @PostMapping(path="/add")
    public @ResponseBody ContractType addNewContractType (@RequestBody ContractType contractType) {

        return contractTypeService.save(contractType);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ContractType> getContractType() {
        return contractTypeService.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Void> deleteContractType(@PathVariable Integer id) {
        contractTypeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
