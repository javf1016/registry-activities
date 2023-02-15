package com.example.registryactivities.service.impl;

import com.example.registryactivities.exception.ResourceNotFoundException;
import com.example.registryactivities.model.Activity;
import com.example.registryactivities.repository.ActivityRepository;
import com.example.registryactivities.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Override
    public List<Activity> getAll() {

        return activityRepository.findAll();
    }
    @Override
    public void save(Activity activity) {
        LocalDate today = LocalDate.now();
        LocalDate estimatedExecutionDate = activity.getDateEstimatedTimeExecution().toLocalDate();
        long daysDifference = ChronoUnit.DAYS.between(today, estimatedExecutionDate);
        if (daysDifference < 0) {
            // La actividad está retrasada
            activity.setDayDelay((int)Math.abs(daysDifference));
        } else {
            // La actividad se está ejecutando en el plazo previsto
            activity.setDayDelay(0);
        }
        activityRepository.save(activity);
    }
    @Override
    public Activity getActivityById(Integer activityId) {
        return activityRepository.findById(activityId).orElseThrow(() -> new ResourceNotFoundException("Activity with given Id: "+activityId+" is not found !!!"));
    }
    @Override
    public void delete(Integer activityId) {
        activityRepository.deleteById(activityId);
    }
}
