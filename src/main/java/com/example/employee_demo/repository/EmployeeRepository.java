package com.example.employee_demo.repository;

import com.example.employee_demo.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Optional<Employee>> findEmployeeByName(String name);
}
