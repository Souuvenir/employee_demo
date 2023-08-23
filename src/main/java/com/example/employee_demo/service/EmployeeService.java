package com.example.employee_demo.service;

import com.example.employee_demo.models.Employee;
import com.example.employee_demo.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ContractService contractService;

    public Employee save(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Iterable<Employee> findAll(){
        Iterable<Employee> all;
        all = employeeRepository.findAll();
        return all;
    }

    @Transactional
    public void deleteById(Integer id){
        contractService.deleteByEmployeeId(id);
        employeeRepository.deleteById(id);
    }

    public Optional<Employee> getById(Integer id){
        return employeeRepository.findById(id);
    }

    public List<Optional<Employee>> getByName(String name){
        return employeeRepository.findEmployeeByName(name);
    }
}
