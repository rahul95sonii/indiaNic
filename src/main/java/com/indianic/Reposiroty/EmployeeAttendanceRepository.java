package com.indianic.Reposiroty;

import com.indianic.Entity.EmployeeAttendanceDetails;
import com.indianic.Entity.EmployeeAttendanceResponse;
import com.indianic.Entity.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendanceDetails, Long> {
    @Query("SELECT ead FROM EmployeeAttendanceDetails ead WHERE ead.employee = :employee AND ead.attendanceDate >= :startDate AND ead.attendanceDate <= :endDate")
    List<EmployeeAttendanceDetails> findEmployeeAttendanceByMonth(@Param("employee") EmployeeMaster employee, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

@Query(value="SELECT \n" +
        "  e.employee_code as empCode," +
        "  e.employee_name as empName," +
        "  d.designation_name as desgName," +
        "  DATE_FORMAT(a.attendance_date, '%Y-%m') AS month,\n" +
        "  a.attendance_date, as attendanceDate" +
        "  a.in_time, as inTime" +
        "  a.out_time, as outTime" +
        "  a.attendance_status as attendanceStatus, " +
        "  COUNT(CASE WHEN a.attendance_status = 'P' THEN 1 END) OVER (PARTITION BY e.employee_id, DATE_FORMAT(a.attendance_date, '%Y-%m')) AS presentCount, " +
        "  COUNT(CASE WHEN a.attendance_status = 'A' THEN 1 END) OVER (PARTITION BY e.employee_id, DATE_FORMAT(a.attendance_date, '%Y-%m')) AS absentCount, " +
        "  COUNT(CASE WHEN a.attendance_status = 'L' THEN 1 END) OVER (PARTITION BY e.employee_id, DATE_FORMAT(a.attendance_date, '%Y-%m')) AS leaveCount " +
        "FROM " +
        "  employee_master e " +
        "  JOIN designation_master d ON e.designation_id = d.designation_id " +
        "  JOIN employee_attendance_details a ON e.employee_id = a.employee_id " +
        "WHERE e.is_active = 'Y'  And  ead.attendanceDate >= :startDate AND ead.attendanceDate <= :endDate" +
        "ORDER BY  e.employee_code, month, a.attendance_date;",nativeQuery = true)
List<EmployeeAttendanceResponse> findEmployeeAttendance(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
