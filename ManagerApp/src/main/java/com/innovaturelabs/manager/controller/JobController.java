package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.form.JobForm;
import com.innovaturelabs.manager.service.JobService;
import com.innovaturelabs.manager.view.JobListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public void add(@RequestBody JobForm form) {
        jobService.add(form);
    }

    @GetMapping
    public List<JobListView> list() {
        return jobService.list();
    }

    @GetMapping("/projectId/{projectId}")
    public List<JobListView> listByProjectId(@PathVariable Integer projectId) {
        return jobService.listByProjectId(projectId);
    }

    @GetMapping("/employeeId/{employeeId}")
    public List<JobListView> listByEmployeeId(@PathVariable Integer employeeId) {
        return jobService.listByEmployeeId(employeeId);
    }

    @GetMapping("/employeeCount")
    public List<Map<Integer, Map<String, Map<String, Integer>>>> getCount() {
        return jobService.getCount();
    }
}
