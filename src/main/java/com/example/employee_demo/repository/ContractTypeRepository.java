package com.example.employee_demo.repository;

import com.example.employee_demo.models.ContractType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeRepository extends CrudRepository<ContractType, Integer> {
}
