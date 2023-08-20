package com.example.employee_demo.service;

import com.example.employee_demo.models.ContractType;
import com.example.employee_demo.repository.ContractTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractTypeService {
    @Autowired
    private ContractTypeRepository contractTypeRepository;

    public ContractType save(ContractType contractType){
        contractTypeRepository.save(contractType);
        return contractType;
    }

    public Iterable<ContractType> findAll(){
        Iterable<ContractType> all;
        all = contractTypeRepository.findAll();
        return all;
    }
}
