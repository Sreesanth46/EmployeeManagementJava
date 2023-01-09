package com.innovaturelabs.common.repository;

import com.innovaturelabs.common.entity.Leaves;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface LeaveRepository extends Repository<Leaves, Integer> {

    Leaves save(Leaves leave);

    List<Leaves> findAll();

    Optional<Leaves> findByEmployeeEmployeeId(Integer employeeId);


    Optional<Leaves> findByLeaveId(Integer leaveId);

    List<Leaves> findAllByEmployeeEmployeeId(Integer employeeId);

}
