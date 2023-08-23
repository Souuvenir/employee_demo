package com.example.employee_demo.service;

import com.example.employee_demo.models.Area;
import com.example.employee_demo.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    public Area save(Area area){
        areaRepository.save(area);
        return area;
    }

    public Iterable<Area> findAll(){
        Iterable<Area> all;
        all = areaRepository.findAll();
        return all;
    }

    public void deleteById(Integer id){
        areaRepository.deleteById(id);
    }
}
