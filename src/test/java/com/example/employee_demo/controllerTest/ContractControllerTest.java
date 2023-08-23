package com.example.employee_demo.controllerTest;


import com.example.employee_demo.controller.ContractController;
import com.example.employee_demo.models.Contract;
import com.example.employee_demo.service.ContractService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ContractControllerTest {

    ContractService contractService = Mockito.mock(ContractService.class);

    @Test
    public void testAddNewContract() {
        Contract contract = new Contract();
        contract.setDescription("Test Description");

        ContractController controller = new ContractController(contractService);
        controller.addNewContract(contract);
        Mockito.when(contractService.save(contract)).thenReturn(contract);
        Mockito.verify(contractService, Mockito.times(1)).save(contract);
    }

    @Test
    public void testUpdateContract() {
        Contract contract = new Contract();
        contract.setId(1);

        ContractController controller = new ContractController(contractService);
        controller.addNewContract(contract);
        Mockito.when(contractService.save(contract)).thenReturn(contract);
        Mockito.verify(contractService, Mockito.times(1)).save(contract);
    }

    @Test
    public void testGetAllContract() {
        Contract contract = new Contract();
        Contract contract2 = new Contract();
        List<Contract> contractList = new ArrayList<>();
        contractList.add(contract);
        contractList.add(contract2);

        ContractController controller = new ContractController(contractService);
        controller.getContract();
        Mockito.when(contractService.findAll()).thenReturn(contractList);
        Mockito.verify(contractService, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteEmployee() {
        ContractController controller = new ContractController(contractService);
        controller.deleteContract(1);
        Mockito.verify(contractService, Mockito.times(1)).deleteById(1);
    }

}
