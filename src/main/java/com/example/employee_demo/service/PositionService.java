package com.example.employee_demo.service;

import com.example.employee_demo.models.Position;
import com.example.employee_demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public Position save(Position position){
        positionRepository.save(position);
        return position;
    }

    public Iterable<Position> findAll(){
        Iterable<Position> all;
        all = positionRepository.findAll();
        return all;
    }

    public void deleteById(Integer id){
        positionRepository.deleteById(id);
    }
}
