package com.example.employee_demo.controllerTest;


import com.example.employee_demo.controller.ContractTypeController;
import com.example.employee_demo.models.ContractType;
import com.example.employee_demo.service.ContractTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ContractTypeControllerTest {

    ContractTypeService contractTypeService = Mockito.mock(ContractTypeService.class);

    @Test
    public void testAddNewContractType() {
        ContractType contractType = new ContractType();
        contractType.setName("Test Type");

        ContractTypeController controller = new ContractTypeController(contractTypeService);
        controller.addNewContractType(contractType);
        Mockito.when(contractTypeService.save(contractType)).thenReturn(contractType);
        Mockito.verify(contractTypeService, Mockito.times(1)).save(contractType);
    }

    @Test
    public void testUpdateNewContractType() {
        ContractType contractType = new ContractType();
        contractType.setId(1);

        ContractTypeController controller = new ContractTypeController(contractTypeService);
        controller.addNewContractType(contractType);
        Mockito.when(contractTypeService.save(contractType)).thenReturn(contractType);
        Mockito.verify(contractTypeService, Mockito.times(1)).save(contractType);
    }

    @Test
    public void testGetAllContractTypes() {
        ContractType contractType = new ContractType();
        ContractType contractType2 = new ContractType();
        List<ContractType> contractTypeList = new ArrayList<>();
        contractTypeList.add(contractType);
        contractTypeList.add(contractType2);

        ContractTypeController controller = new ContractTypeController(contractTypeService);
        controller.getContractType();
        Mockito.when(contractTypeService.findAll()).thenReturn(contractTypeList);
        Mockito.verify(contractTypeService, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteEmployee() {
        ContractTypeController controller = new ContractTypeController(contractTypeService);
        controller.deleteContractType(1);
        Mockito.verify(contractTypeService, Mockito.times(1)).deleteById(1);
    }

}
