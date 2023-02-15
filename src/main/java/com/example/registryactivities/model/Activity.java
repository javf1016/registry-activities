package com.example.registryactivities.model;

import com.example.registryactivities.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Integer activityId;

    private String name;
    private String description;
    private Status status;
    private LocalDateTime DateEstimatedTimeExecution;
    private int dayDelay;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

}
