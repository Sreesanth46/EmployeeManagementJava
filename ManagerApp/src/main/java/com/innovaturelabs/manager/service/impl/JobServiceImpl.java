package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.entity.Job;
import com.innovaturelabs.common.entity.Tasks;
import com.innovaturelabs.common.form.JobForm;
import com.innovaturelabs.common.repository.EmployeeRepository;
import com.innovaturelabs.common.repository.JobRepository;
import com.innovaturelabs.common.repository.TasksRepository;
import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.manager.service.JobService;
import com.innovaturelabs.manager.view.JobListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author Sreesanth
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public void add(JobForm form) throws BadRequestException {
        addJob(form.getEmployeeId(), form.getTaskId(), form.getCompletionDate());
        form.getAlternativeEmployeeId().forEach(id ->{
            addJob(id, form.getTaskId(), form.getCompletionDate());
        });
    }

    private void addJob(Integer employeeId, Integer taskId, Date completionDate) {
        Optional<Employee> employee =  employeeRepository.findByEmployeeId(employeeId);
        Optional<Tasks> tasks = tasksRepository.findByTaskId(taskId);
        if (employee.isEmpty()) {
            throw new BadRequestException("Invalid EmployeeId - Not Found");
        } else if (tasks.isEmpty()) {
            throw new BadRequestException("Invalid TaskId - Not Found");
        } else {
            jobRepository.save(new Job(employeeId, taskId, completionDate));
        }
    }

    @Override
    public List<JobListView> list() {
        return StreamSupport.stream(jobRepository
                .findAll().spliterator(), false)
                .map(JobListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobListView> listByProjectId(Integer projectId) {
        return jobRepository.findAllByTasksPhaseSectionProjectPhaseProjectProjectId(projectId)
                .stream()
                .map(JobListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobListView> listByEmployeeId(Integer employeeId) {
        return jobRepository.findAllByEmployeeEmployeeId(employeeId)
                .stream()
                .map(JobListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<Integer, Map<String, Map<String, Integer>>>> getCount() {
        return jobRepository.getEmployeeCount();
    }
}
