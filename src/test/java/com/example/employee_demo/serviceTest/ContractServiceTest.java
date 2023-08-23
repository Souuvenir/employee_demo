package com.example.employee_demo.serviceTest;

import com.example.employee_demo.models.Contract;
import com.example.employee_demo.repository.ContractRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ContractServiceTest {

    ContractRepository contractRepository = Mockito.mock(ContractRepository.class);

    @Test
    public void testSave() {
        Contract contract = new Contract();
        contract.setDescription("Test Contract");

        contractRepository.save(contract);
        Mockito.when(contractRepository.save(contract)).thenReturn(contract);
        Mockito.verify(contractRepository, Mockito.times(1)).save(contract);
    }

    @Test
    public void testUpdateContract() {
        Contract contract = new Contract();
        contract.setId(1);
        contract.setDescription("Test");

        contractRepository.save(contract);
        Mockito.when(contractRepository.save(contract)).thenReturn(contract);
        Mockito.verify(contractRepository, Mockito.times(1)).save(contract);
    }

    @Test
    public void testFindAll() {
        Contract contract = new Contract();
        Contract contract2 = new Contract();
        List<Contract> contractList = new ArrayList<>();
        contractList.add(contract);
        contractList.add(contract2);

        contractRepository.findAll();
        Mockito.when(contractRepository.findAll()).thenReturn(contractList);
        Mockito.verify(contractRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        contractRepository.deleteById(1);
        Mockito.verify(contractRepository, Mockito.times(1)).deleteById(1);
    }
}
