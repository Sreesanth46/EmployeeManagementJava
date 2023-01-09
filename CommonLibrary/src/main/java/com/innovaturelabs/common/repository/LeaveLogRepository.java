package com.innovaturelabs.common.repository;
import com.innovaturelabs.common.entity.LeaveLog;
import com.innovaturelabs.common.entity.Leaves;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface LeaveLogRepository extends Repository<LeaveLog, Integer>{

    LeaveLog save(LeaveLog leaveLog);
    
    Optional<LeaveLog> findByLeaveLogId(Integer leaveLogId);
    
    List<LeaveLog> findAllByLeavesEmployeeEmployeeId(Integer employeeId);

    List<LeaveLog> findAll();

    List<LeaveLog> findAllByLeaveStatus(byte status);

}
