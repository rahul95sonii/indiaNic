package com.indianic.Entity;

import java.text.DateFormat;
import java.util.Date;

public interface EmployeeAttendanceResponse {

    public String getEmpCode();

    public String getEmpName();

    public String getDesgName();

    public DateFormat getMonth();

    public Date getAttendanceDate();

    public Date getInTime();

    public Date getOutTime();

    public String getAttendanceStatus();

    public Integer getPresentCount();

    public Integer getAbsentCount();

    public Integer getLeaveCount();

}
