package com.indianic.Service;

import com.indianic.Dao.EmployeeAttendanceDTO;
import com.indianic.Entity.EmployeeAttendanceDetails;
import com.indianic.Entity.EmployeeAttendanceResponse;
import com.indianic.Entity.EmployeeMaster;
import com.indianic.Reposiroty.EmployeeAttendanceRepository;
import com.indianic.Reposiroty.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeAttendanceRepository employeeAttendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeAttendanceDTO> getEmployeeMonthWiseAttendance(Long employeeId, Date startDate, Date endDate) {
        EmployeeMaster employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee is not present in system"));

        List<EmployeeAttendanceDetails> attendanceDetails = employeeAttendanceRepository.findEmployeeAttendanceByMonth(employee, startDate, endDate);
        List<EmployeeAttendanceDTO> attendanceDTOs = new ArrayList<>();
        for (EmployeeAttendanceDetails attendanceDetail : attendanceDetails) {
            EmployeeAttendanceDTO attendanceDTO = new EmployeeAttendanceDTO();
            attendanceDTO.setEmployeeCode(employee.getEmployeeCode());
            attendanceDTO.setEmployeeName(employee.getEmployeeName());
            attendanceDTO.setDesignationCode(employee.getDesignation().getDesignationCode());
            attendanceDTO.setDesignationName(employee.getDesignation().getDesignationName());
            attendanceDTO.setAttendanceDate(attendanceDetail.getAttendanceDate());
            attendanceDTO.setInTime(attendanceDetail.getInTime());
            attendanceDTO.setOutTime(attendanceDetail.getOutTime());
            attendanceDTO.setAttendanceStatus(attendanceDetail.getAttendanceStatus());
            attendanceDTOs.add(attendanceDTO);
        }
        return attendanceDTOs;
    }

    public List<EmployeeAttendanceDTO> getEmployeeMonthWiseAttend(String startDate, String endDate) {

        List<EmployeeAttendanceResponse> attendanceDetails = employeeAttendanceRepository.findEmployeeAttendance( startDate, endDate);
        List<EmployeeAttendanceDTO> attendanceDTOs = new ArrayList<>();
        for (EmployeeAttendanceResponse attendanceDetail : attendanceDetails) {
            EmployeeAttendanceDTO attendanceDTO = new EmployeeAttendanceDTO();
            attendanceDTO.setEmployeeCode(attendanceDetail.getEmpCode());
            attendanceDTO.setEmployeeName(attendanceDetail.getEmpName());
            attendanceDTO.setDesignationCode(attendanceDetail.getDesgName());
            attendanceDTO.setDesignationName(attendanceDetail.getDesgName());
            attendanceDTO.setAttendanceDate(attendanceDetail.getAttendanceDate());
            attendanceDTO.setInTime(attendanceDetail.getInTime());
            attendanceDTO.setOutTime(attendanceDetail.getOutTime());
            attendanceDTO.setAttendanceStatusCode(attendanceDetail.getAttendanceStatus());
            attendanceDTO.setPresentCount(attendanceDetail.getPresentCount());
            attendanceDTO.setLeaveCount(attendanceDetail.getLeaveCount());
            attendanceDTO.setAbsentCount(attendanceDetail.getAbsentCount());
            attendanceDTOs.add(attendanceDTO);
        }
        return attendanceDTOs;
    }


    }

