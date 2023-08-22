package com.example.employee_demo.repository;


import com.example.employee_demo.models.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Integer> {
    void deleteByEmployeeId(Integer employeeId);
}
