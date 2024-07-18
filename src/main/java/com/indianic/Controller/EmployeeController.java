package com.indianic.Controller;

import com.indianic.Dao.EmployeeAttendanceDTO;
import com.indianic.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}/attendance")
    public List<EmployeeAttendanceDTO> getEmployeeMonthWiseAttendance(@PathVariable Long employeeId, @RequestParam Date startDate, @RequestParam Date endDate) {
        return employeeService.getEmployeeMonthWiseAttendance(employeeId, startDate, endDate);
    }

    @GetMapping("/attendance")
    public List<EmployeeAttendanceDTO> getEmployeeMonthWiseAttend(@RequestParam String startDate, @RequestParam String endDate) {
        return employeeService.getEmployeeMonthWiseAttend(startDate, endDate);
    }
}
