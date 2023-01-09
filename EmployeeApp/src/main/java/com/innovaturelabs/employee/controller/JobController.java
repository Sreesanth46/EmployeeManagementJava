package com.innovaturelabs.employee.controller;

import java.util.List;


import com.innovaturelabs.common.form.ResetStatusForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovaturelabs.employee.service.JobService;
import com.innovaturelabs.employee.view.JobListView;

@RestController
@RequestMapping("/task")
public class JobController {
    @Autowired
    private JobService jobService;

   @GetMapping("/{employeeId}")
   public List<JobListView> list(@PathVariable Integer employeeId){
       return jobService.list(employeeId);
   }

   @PutMapping("/reset/{jobId}")
   public JobListView update (@PathVariable Integer jobId,@RequestBody ResetStatusForm form){
       return jobService.update(jobId,form);
   }

}
