package com.example.employee_demo.controllerTest;

import com.example.employee_demo.controller.PositionController;
import com.example.employee_demo.models.Position;
import com.example.employee_demo.service.PositionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PositionControllerTest {

    PositionService positionService = Mockito.mock(PositionService.class);

    @Test
    public void testAddNewPosition() {
        Position position = new Position();
        position.setPosition("Test Position");

        PositionController controller = new PositionController(positionService);
        controller.addNewPosition(position);
        Mockito.when(positionService.save(position)).thenReturn(position);
        Mockito.verify(positionService, Mockito.times(1)).save(position);
    }

    @Test
    public void testUpdateNewPosition() {
        Position position = new Position();
        position.setId(1);
        position.setPosition("Test Position");

        PositionController controller = new PositionController(positionService);
        controller.addNewPosition(position);
        Mockito.when(positionService.save(position)).thenReturn(position);
        Mockito.verify(positionService, Mockito.times(1)).save(position);
    }

    @Test
    public void testGetAllPositions() {
        Position position = new Position();
        Position position2 = new Position();
        List<Position> positionList = new ArrayList<>();
        positionList.add(position);
        positionList.add(position2);

        PositionController controller = new PositionController(positionService);
        controller.getAllPositions();
        Mockito.when(positionService.findAll()).thenReturn(positionList);
        Mockito.verify(positionService, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeletePosition() {
        PositionController controller = new PositionController(positionService);
        controller.deletePosition(1);
        Mockito.verify(positionService, Mockito.times(1)).deleteById(1);
    }

}
