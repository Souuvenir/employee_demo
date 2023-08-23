package com.example.employee_demo.controllerTest;


import com.example.employee_demo.controller.EmployeeController;
import com.example.employee_demo.models.Employee;
import com.example.employee_demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class EmployeeControllerTest {

    EmployeeService employeeService = Mockito.mock(EmployeeService.class);

    @Test
    public void testAddNewEmployee() {
        Employee employee = new Employee();
        employee.setName("Test");

        EmployeeController controller = new EmployeeController(employeeService);
        controller.addNewUser(employee);
        Mockito.when(employeeService.save(employee)).thenReturn(employee);
        Mockito.verify(employeeService, Mockito.times(1)).save(employee);
    }

    @Test
    public void testUpdateNewPosition() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Test Update");

        EmployeeController controller = new EmployeeController(employeeService);
        controller.addNewUser(employee);
        Mockito.when(employeeService.save(employee)).thenReturn(employee);
        Mockito.verify(employeeService, Mockito.times(1)).save(employee);
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee = new Employee();
        Employee employee2 = new Employee();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        employeeList.add(employee2);

        EmployeeController controller = new EmployeeController(employeeService);
        controller.getAllUsers();
        Mockito.when(employeeService.findAll()).thenReturn(employeeList);
        Mockito.verify(employeeService, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteEmployee() {
        EmployeeController controller = new EmployeeController(employeeService);
        controller.deleteEmployee(1);
        Mockito.verify(employeeService, Mockito.times(1)).deleteById(1);
    }

}
