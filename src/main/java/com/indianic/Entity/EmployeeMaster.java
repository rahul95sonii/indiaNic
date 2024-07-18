package com.indianic.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_master")
public class EmployeeMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    @ManyToOne
    @JoinColumn(name = "designation_id")
    private DesignationMaster designation;
    private char isActive;

    // getters and setters
}