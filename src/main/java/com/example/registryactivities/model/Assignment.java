package com.example.registryactivities.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "assigments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assigment_id")
    private Integer assigmentId;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activityId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    private LocalDateTime timeAssignment;

}
