package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Map;

public interface JobRepository extends Repository<Job, Integer> {

    Job save(Job job);

    List<Job> findAll();

    List<Job> findAllByEmployeeEmployeeId(Integer employeeId);

    Job findByJobId(Integer jobId);

    List<Job> findAllByTasksPhaseSectionProjectPhaseProjectProjectId(Integer projectId);

    @Query(value = "SELECT j.employee_id,e.employee_name,e.employee_email, COUNT(*) as count FROM job j INNER join employee e on j.employee_id=e.employee_id GROUP BY j.employee_id", nativeQuery = true)
    List<Map<Integer, Map<String, Map<String, Integer>>>> getEmployeeCount();
}
