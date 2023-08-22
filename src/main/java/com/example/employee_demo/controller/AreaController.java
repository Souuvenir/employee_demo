package com.example.employee_demo.controller;

import com.example.employee_demo.models.Area;
import com.example.employee_demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@CrossOrigin( value = "http://localhost:3000")
@Controller
@RequestMapping(path="/area")
public class AreaController {
    @Autowired
    AreaService areaService;

    @PostMapping(path="/add")
    public @ResponseBody Area addNewArea (@RequestBody Area area) {

        return areaService.save(area);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Area> getArea() {
        return areaService.findAll();
    }

    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable Integer id) {
        areaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
