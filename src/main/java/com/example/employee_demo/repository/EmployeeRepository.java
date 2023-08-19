package com.example.employee_demo.repository;

import com.example.employee_demo.models.EmployeeModel;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeModel, Integer> {
}
