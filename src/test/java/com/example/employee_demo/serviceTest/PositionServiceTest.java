package com.example.employee_demo.serviceTest;

import com.example.employee_demo.models.Position;
import com.example.employee_demo.repository.PositionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PositionServiceTest {

    PositionRepository positionRepository = Mockito.mock(PositionRepository.class);

    @Test
    public void testSave() {
        Position position = new Position();
        position.setPosition("Test Position");

        positionRepository.save(position);
        Mockito.when(positionRepository.save(position)).thenReturn(position);
        Mockito.verify(positionRepository, Mockito.times(1)).save(position);
    }

    @Test
    public void testUpdatePosition() {
        Position position = new Position();
        position.setId(1);
        position.setPosition("Test");

        positionRepository.save(position);
        Mockito.when(positionRepository.save(position)).thenReturn(position);
        Mockito.verify(positionRepository, Mockito.times(1)).save(position);
    }

    @Test
    public void testFindAllPositions() {
        Position position = new Position();
        Position position2 = new Position();
        List<Position> positionList = new ArrayList<>();
        positionList.add(position);
        positionList.add(position2);

        positionRepository.findAll();
        Mockito.when(positionRepository.findAll()).thenReturn(positionList);
        Mockito.verify(positionRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeletebyIdPosition() {
        positionRepository.deleteById(1);
        Mockito.verify(positionRepository, Mockito.times(1)).deleteById(1);
    }
}