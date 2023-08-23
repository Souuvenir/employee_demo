package com.example.employee_demo.serviceTest;

import com.example.employee_demo.models.Employee;
import com.example.employee_demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceTest {

    EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("Test Position");

        employeeRepository.save(employee);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Test");

        employeeRepository.save(employee);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void testFindAll() {
        Employee employee = new Employee();
        Employee employee2 = new Employee();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee);

        employeeRepository.findAll();
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        Mockito.verify(employeeRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeletebyId() {
        employeeRepository.deleteById(1);
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(1);
    }
}