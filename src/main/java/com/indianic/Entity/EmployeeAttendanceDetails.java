package com.indianic.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

    @Entity
    @Data
    @Table(name = "employee_attendance_details")
    public class EmployeeAttendanceDetails {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long employeeAttendanceDetailId;
        @ManyToOne
        @JoinColumn(name = "employee_id")
        private EmployeeMaster employee;
        private Date inTime;
        private Date outTime;
        private Date attendanceDate;
        private char attendanceStatus;

    }
