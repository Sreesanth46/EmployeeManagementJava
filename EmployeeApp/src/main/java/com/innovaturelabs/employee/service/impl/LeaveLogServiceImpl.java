package com.innovaturelabs.employee.service.impl;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.entity.LeaveLog;
import com.innovaturelabs.common.entity.Leaves;
import com.innovaturelabs.common.form.LeaveLogForm;
import com.innovaturelabs.common.repository.EmployeeRepository;
import com.innovaturelabs.employee.security.util.SecurityUtil;
import com.innovaturelabs.employee.service.LeaveLogService;
import com.innovaturelabs.employee.view.LeaveListView;
import com.innovaturelabs.employee.view.LeaveLogListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innovaturelabs.common.repository.LeaveLogRepository;
import com.innovaturelabs.common.repository.LeaveRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LeaveLogServiceImpl implements LeaveLogService {

    @Autowired
    private LeaveLogRepository leaveLogRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public LeaveLogListView add(LeaveLogForm form) {
        Optional<Employee> employee = employeeRepository.findByEmployeeId(SecurityUtil.getCurrentUserId());
        Optional<Leaves> leaves= leaveRepository.findByEmployeeEmployeeId(employee.get().getEmployeeId());
        return new LeaveLogListView(leaveLogRepository.save(new LeaveLog(form, leaves.get().getLeaveId())));
    }

    @Override
    public List<LeaveLogListView> list() {
        return StreamSupport.stream(leaveLogRepository.findAllByLeavesEmployeeEmployeeId(SecurityUtil.getCurrentUserId()).spliterator(), false)
                .map(LeaveLog -> new LeaveLogListView(LeaveLog))
                .collect(Collectors.toList());
    }
    @Override
    public List<LeaveListView> display() {
        return StreamSupport.stream(leaveRepository.findAllByEmployeeEmployeeId(SecurityUtil.getCurrentUserId()).spliterator(), false)
                .map(Leaves -> new LeaveListView(Leaves))
                .collect(Collectors.toList());
    }

}
