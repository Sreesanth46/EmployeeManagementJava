package com.innovaturelabs.common.repository;


import org.springframework.data.repository.Repository;

import com.innovaturelabs.common.entity.EmployeeJob;

import java.util.List;
import java.util.Optional;

public interface EmployeeJobRepository extends Repository<EmployeeJob, Integer> {

    EmployeeJob save(EmployeeJob employeeJob);

    List<EmployeeJob> findAll();

    EmployeeJob findAllByEmployeeEmployeeIdAndProjectProjectId(Integer employeeId,Integer projectId);

    List<EmployeeJob> findAllByEmployeeEmployeeId(Integer employeeId);

    Optional<EmployeeJob> findByJobId(Integer jobId);
}
