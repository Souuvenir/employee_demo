package com.example.employee_demo.service;

import com.example.employee_demo.models.Contract;
import com.example.employee_demo.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    private ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract save(Contract contract){
        contractRepository.save(contract);
        return contract;
    }

    public Iterable<Contract> findAll(){
        Iterable<Contract> all;
        all = contractRepository.findAll();
        return all;
    }

    public void deleteById(Integer id){
        contractRepository.deleteById(id);
    }

    public void deleteByEmployeeId(Integer id) {
        contractRepository.deleteByEmployeeId(id);
    }
}
