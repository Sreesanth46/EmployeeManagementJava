package com.innovaturelabs.employee.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.innovaturelabs.common.form.ResetStatusForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovaturelabs.common.entity.Job;
import com.innovaturelabs.common.repository.JobRepository;
import com.innovaturelabs.employee.service.JobService;
import com.innovaturelabs.employee.view.JobListView;

@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository jobRepository;

   @Override
   public List<JobListView> list(Integer employeeId){
       return StreamSupport.stream(jobRepository.findAllByEmployeeEmployeeId(employeeId).spliterator(),false)
       .map(Job->new JobListView(Job))
       .collect(Collectors.toList());
   }

    @Override
    public JobListView update(Integer jobId, ResetStatusForm form){
        Job job=jobRepository.findByJobId(jobId);
        job.getTasks().setTaskStatus(form.getTaskStatus());
        jobRepository.save(job);
        return new JobListView(job);
    }

}
