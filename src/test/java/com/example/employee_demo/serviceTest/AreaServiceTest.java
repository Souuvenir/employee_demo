package com.example.employee_demo.serviceTest;

import com.example.employee_demo.models.Area;
import com.example.employee_demo.repository.AreaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class AreaServiceTest {

    AreaRepository areaRepository = Mockito.mock(AreaRepository.class);

    @Test
    public void testSave() {
        Area area = new Area();
        area.setArea("Test Area");

        areaRepository.save(area);
        Mockito.when(areaRepository.save(area)).thenReturn(area);
        Mockito.verify(areaRepository, Mockito.times(1)).save(area);
    }

    @Test
    public void testUpdateArea() {
        Area area = new Area();
        area.setId(1);
        area.setArea("Test");

        areaRepository.save(area);
        Mockito.when(areaRepository.save(area)).thenReturn(area);
        Mockito.verify(areaRepository, Mockito.times(1)).save(area);
    }

    @Test
    public void testFindAll() {
        Area area = new Area();
        Area area2 = new Area();
        List<Area> areaList = new ArrayList<>();
        areaList.add(area);
        areaList.add(area2);

        areaRepository.findAll();
        Mockito.when(areaRepository.findAll()).thenReturn(areaList);
        Mockito.verify(areaRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testDeleteById() {
        areaRepository.deleteById(1);
        Mockito.verify(areaRepository, Mockito.times(1)).deleteById(1);
    }
}
