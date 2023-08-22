package com.example.employee_demo.controller;

import com.example.employee_demo.models.Position;
import com.example.employee_demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( value = "http://localhost:3000")
@Controller
@RequestMapping(path="/position")
public class PositionController {
    @Autowired
    PositionService positionService;

    @PostMapping(path="/add")
    public @ResponseBody Position addNewPosition (@RequestBody Position position) {

        return positionService.save(position);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Position> getAllPositions() {

        return positionService.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable Integer id) {
        positionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
