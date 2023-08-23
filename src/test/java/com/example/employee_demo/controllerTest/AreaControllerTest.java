package com.example.employee_demo.controllerTest;


import com.example.employee_demo.controller.AreaController;
import com.example.employee_demo.controller.ContractController;
import com.example.employee_demo.models.Area;
import com.example.employee_demo.models.Contract;
import com.example.employee_demo.service.AreaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class AreaControllerTest {

    AreaService areaService = Mockito.mock(AreaService.class);

    @Test
    public void testAddNewArea() {
        Area area = new Area();
        area.setArea("Area Test");

        AreaController controller = new AreaController(areaService);
        controller.addNewArea(area);
        Mockito.when(areaService.save(area)).thenReturn(area);
        Mockito.verify(areaService, Mockito.times(1)).save(area);
    }

    @Test
    public void testUpdateArea() {
        Area area = new Area();
        area.setId(1);

        AreaController controller = new AreaController(areaService);
        controller.addNewArea(area);
        Mockito.when(areaService.save(area)).thenReturn(area);
        Mockito.verify(areaService, Mockito.times(1)).save(area);
    }

    @Test
    public void testGetAllAreas() {
        Area area = new Area();
        Area area2 = new Area();
        List<Area> areaList = new ArrayList<>();
        areaList.add(area);
        areaList.add(area2);

        AreaController controller = new AreaController(areaService);
        controller.getArea();
        Mockito.when(areaService.findAll()).thenReturn(areaList);
        Mockito.verify(areaService, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteEmployee() {
        AreaController controller = new AreaController(areaService);
        controller.deleteArea(1);
        Mockito.verify(areaService, Mockito.times(1)).deleteById(1);
    }

}
