package com.example.registryactivities.service;

import com.example.registryactivities.model.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {

    public List<Activity> getAll();
    public void save(Activity activity);
    public Activity getActivityById(Integer activityId);
    public void delete(Integer activityId);

}
