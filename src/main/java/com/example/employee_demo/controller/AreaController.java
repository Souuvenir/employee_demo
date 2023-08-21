package com.example.employee_demo.controller;

import com.example.employee_demo.models.Area;
import com.example.employee_demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path="/delete")
    public ResponseEntity<Void> deleteArea(@RequestBody Area area) {
        areaService.deleteById(area.getId());
        return ResponseEntity.ok().build();
    }

}
