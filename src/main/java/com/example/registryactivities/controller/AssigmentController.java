package com.example.registryactivities.controller;

import com.example.registryactivities.model.Assignment;
import com.example.registryactivities.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assigments")
public class AssigmentController {

    @Autowired
    private AssigmentService assigmentService;

    @GetMapping
    public List<Assignment> getAll() {
        return assigmentService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Assignment assignment) {
        assigmentService.save(assignment);
    }

    @GetMapping("/{assigmentId}")
    public Assignment getAssigmentById(@PathVariable Integer assigmentId) {
        return assigmentService.getAssigmentById(assigmentId);
    }

    @PutMapping("/{assigmentId}")
    public void update(@PathVariable Integer assigmentId, @RequestBody Assignment assignment) {
        Assignment existAssigment = assigmentService.getAssigmentById(assigmentId);
        if (existAssigment != null) {
            existAssigment.setEmployeeId(assignment.getEmployeeId());
            existAssigment.setActivityId(assignment.getActivityId());
            existAssigment.setTimeAssignment(assignment.getTimeAssignment());
            assigmentService.save(existAssigment);
        }
    }

    @DeleteMapping("/{assigmentId}")
    public void delete(@PathVariable Integer assigmentId) {
        Assignment existAssigment = assigmentService.getAssigmentById(assigmentId);
        if (existAssigment != null) {
            assigmentService.delete(assigmentId);
        }
    }
}
