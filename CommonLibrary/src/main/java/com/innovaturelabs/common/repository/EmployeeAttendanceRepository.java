package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.EmployeeAttendance;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


public interface EmployeeAttendanceRepository extends Repository<EmployeeAttendance,Integer> {

    List<EmployeeAttendance> findByEmployeeEmployeeId(Integer employeeId);

    Optional<EmployeeAttendance> findAllByEmployeeEmployeeId(Integer employeeId);

    EmployeeAttendance save(EmployeeAttendance employeeAttendance);

}
