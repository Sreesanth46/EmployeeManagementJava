package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.form.EmployeeJobForm;
import com.innovaturelabs.manager.service.EmployeeJobService;
import com.innovaturelabs.manager.view.EmployeeJobListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/employeeJobs")
public class EmployeeJobController {

    @Autowired
    private EmployeeJobService employeeJobService;

    @PostMapping
    public EmployeeJobListView add(@RequestBody EmployeeJobForm form) {
        return employeeJobService.add(form);
    }

    @GetMapping
    public List<EmployeeJobListView> listJobs() {
        return employeeJobService.list();
    }

    @PutMapping("/{jobId}")
    public EmployeeJobListView update(
            @PathVariable("jobId") Integer jobId,
            @RequestBody EmployeeJobForm form)      {
        return employeeJobService.update(jobId, form);
    }
}
