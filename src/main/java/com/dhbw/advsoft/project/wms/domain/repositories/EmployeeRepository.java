package com.dhbw.advsoft.project.wms.domain.repositories;

import com.dhbw.advsoft.project.wms.domain.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee, Long> {
}
