package com.innovaturelabs.employee.service;

import java.util.List;

import com.innovaturelabs.employee.view.EmployeeAttendanceListView;

public interface EmployeeAttendanceService {
    List<EmployeeAttendanceListView> list();
    EmployeeAttendanceListView add();
}
