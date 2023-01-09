package com.innovaturelabs.employee.controller;


import java.util.List;


import com.innovaturelabs.employee.view.ProjectListView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.innovaturelabs.employee.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectservice;

    @GetMapping
    public List<ProjectListView> list(){
        return projectservice.list();
    }

}
