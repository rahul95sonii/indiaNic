package com.indianic.Dao;

import lombok.Data;

import java.util.Date;
@Data
public class EmployeeAttendanceDTO {
    private String employeeCode;
    private String employeeName;
    private String designationCode;
    private String designationName;
    private Date attendanceDate;
    private Date inTime;
    private Date outTime;
    private char attendanceStatus;
    private String attendanceStatusCode;
private Integer presentCount;
    private Integer absentCount;
    private Integer leaveCount;
    // getters and setters
}
