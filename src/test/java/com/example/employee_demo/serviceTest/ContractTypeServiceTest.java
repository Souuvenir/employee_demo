package com.example.employee_demo.serviceTest;

import com.example.employee_demo.models.ContractType;
import com.example.employee_demo.repository.ContractTypeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ContractTypeServiceTest {

    ContractTypeRepository contractTypeRepository = Mockito.mock(ContractTypeRepository.class);

    @Test
    public void testSave() {
        ContractType contractType = new ContractType();
        contractType.setName("Test Position");

        contractTypeRepository.save(contractType);
        Mockito.when(contractTypeRepository.save(contractType)).thenReturn(contractType);
        Mockito.verify(contractTypeRepository, Mockito.times(1)).save(contractType);
    }

    @Test
    public void testUpdateContractType() {
        ContractType contractType = new ContractType();
        contractType.setId(1);
        contractType.setName("Test");

        contractTypeRepository.save(contractType);
        Mockito.when(contractTypeRepository.save(contractType)).thenReturn(contractType);
        Mockito.verify(contractTypeRepository, Mockito.times(1)).save(contractType);
    }

    @Test
    public void testFindAll() {
        ContractType contractType = new ContractType();
        ContractType contractType2 = new ContractType();
        List<ContractType> contractTypeList = new ArrayList<>();
        contractTypeList.add(contractType);
        contractTypeList.add(contractType2);

        contractTypeRepository.findAll();
        Mockito.when(contractTypeRepository.findAll()).thenReturn(contractTypeList);
        Mockito.verify(contractTypeRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeletebyId() {
        contractTypeRepository.deleteById(1);
        Mockito.verify(contractTypeRepository, Mockito.times(1)).deleteById(1);
    }
}