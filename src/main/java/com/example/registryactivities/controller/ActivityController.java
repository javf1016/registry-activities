package com.example.registryactivities.controller;

import com.example.registryactivities.enums.Status;
import com.example.registryactivities.model.Activity;
import com.example.registryactivities.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
@CrossOrigin(origins = "http://localhost:4200/")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getAll() {
        return activityService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Activity activity) {
        activityService.save(activity);
    }

    @GetMapping("/{activityId}")
    public Activity getActivityById(@PathVariable Integer activityId) {
        return activityService.getActivityById(activityId);
    }

    @PutMapping("/{activityId}")
    public void update(@PathVariable Integer activityId, @RequestBody Activity activity) {
        Activity existActivity = activityService.getActivityById(activityId);
        if (existActivity != null) {
            existActivity.setName(activity.getName());
            existActivity.setEmployeeId(activity.getEmployeeId());
            existActivity.setDescription(activity.getDescription());
            existActivity.setStatus(activity.getStatus());
            existActivity.setDateEstimatedTimeExecution(activity.getDateEstimatedTimeExecution());
            activityService.save(existActivity);
        }
    }

    @DeleteMapping("/{activityId}")
    public void delete(@PathVariable Integer activityId) {
        Activity existActivity = activityService.getActivityById(activityId);
        if (existActivity != null) {
            activityService.delete(activityId);
        }
    }
}
