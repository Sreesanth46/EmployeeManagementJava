package com.innovaturelabs.employee.service.impl;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.entity.EmployeeAttendance;
import com.innovaturelabs.common.repository.EmployeeAttendanceRepository;
import com.innovaturelabs.employee.security.util.SecurityUtil;
import com.innovaturelabs.employee.service.EmployeeAttendanceService;
import com.innovaturelabs.employee.view.EmployeeAttendanceListView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {
    @Autowired
    private EmployeeAttendanceRepository employeeAttendanceRepository;

    @Override
    public List<EmployeeAttendanceListView> list() {
        return StreamSupport.stream(employeeAttendanceRepository
                        .findByEmployeeEmployeeId(SecurityUtil.getCurrentUserId()).spliterator(), false)
                .map(EmployeeAttendance -> new EmployeeAttendanceListView(EmployeeAttendance))
                .collect(Collectors.toList());
    }
    @Override
    public EmployeeAttendanceListView add() {
        return new EmployeeAttendanceListView(employeeAttendanceRepository.save(new EmployeeAttendance(SecurityUtil.getCurrentUserId())));
    }
}
