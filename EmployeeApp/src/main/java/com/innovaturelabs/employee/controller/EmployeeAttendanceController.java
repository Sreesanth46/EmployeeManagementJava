package com.innovaturelabs.employee.controller;

import com.innovaturelabs.employee.service.EmployeeAttendanceService;
import com.innovaturelabs.employee.view.EmployeeAttendanceListView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Attendance")
public class EmployeeAttendanceController {
    @Autowired
    private EmployeeAttendanceService employeeAttendanceService;

    @GetMapping
    List<EmployeeAttendanceListView> list(){
        return employeeAttendanceService.list();
    }

    @PostMapping
    public EmployeeAttendanceListView add(){
        return employeeAttendanceService.add();
    }

}
