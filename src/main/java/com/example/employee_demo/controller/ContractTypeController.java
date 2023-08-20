package com.example.employee_demo.controller;

import com.example.employee_demo.models.ContractType;
import com.example.employee_demo.service.ContractTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/contract-type")
public class ContractTypeController {
    @Autowired
    ContractTypeService contractTypeService;

    @PostMapping(path="/add")
    public @ResponseBody ContractType addNewContractType (@RequestBody ContractType contractType) {

        return contractTypeService.save(contractType);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ContractType> getContractType() {
        return contractTypeService.findAll();
    }
}