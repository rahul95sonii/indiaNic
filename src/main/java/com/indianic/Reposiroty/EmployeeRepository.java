package com.indianic.Reposiroty;


import com.indianic.Entity.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<EmployeeMaster, Long> {
    Optional<EmployeeMaster> findById(Long id);
}
