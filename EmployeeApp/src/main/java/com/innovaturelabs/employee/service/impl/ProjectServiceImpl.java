package com.innovaturelabs.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.innovaturelabs.common.entity.Job;
import com.innovaturelabs.common.repository.JobRepository;
import com.innovaturelabs.employee.view.ProjectListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innovaturelabs.common.repository.EmployeeJobRepository;
import com.innovaturelabs.employee.security.util.SecurityUtil;
import com.innovaturelabs.employee.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private EmployeeJobRepository employeeJobRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<ProjectListView> list() {
        return StreamSupport.stream(jobRepository
                .findAllByEmployeeEmployeeId(SecurityUtil.getCurrentUserId()).spliterator(), false).map(Job->new ProjectListView(Job)).collect(Collectors.toList());
    }
}
