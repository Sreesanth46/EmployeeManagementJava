package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.entity.EmployeeJob;
import com.innovaturelabs.common.repository.EmployeeRepository;
import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.common.form.EmployeeJobForm;
import com.innovaturelabs.common.repository.EmployeeJobRepository;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.security.config.SecurityConfig;
import com.innovaturelabs.manager.security.util.TokenGenerator;
import com.innovaturelabs.manager.service.EmailSenderService;
import com.innovaturelabs.manager.service.EmployeeJobService;
import com.innovaturelabs.manager.view.EmployeeJobListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innovaturelabs.manager.security.util.TokenGenerator.Token;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 *
 * @author Sreesanth
 */
@Service
public class EmployeeJobServiceImpl implements EmployeeJobService {

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";

    @Autowired
    private EmployeeJobRepository employeeJobRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private EmailSenderService emailSenderService;

    private static BadRequestException multipleJobException() {
        return new BadRequestException("Cannot assign multiple jobs to a single employee");
    }

    @Override
    public EmployeeJobListView add(EmployeeJobForm form) throws BadRequestException {
//        if(!employeeJobRepository.findByEmployeeEmployeeId(form.getEmployeeId()))
//        {
//            employeeJobRepository.save(new EmployeeJob(form));
//        }
//        throw multipleJobException();
        Optional<Employee> employeeData= employeeRepository.findByEmployeeId(form.getEmployeeId());
        if(employeeData.isEmpty())
        {
            throw  new BadRequestException("No employee found");
        }
        //            String email = employeeData.get().getEmployeeEmail();
//            Token validationToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, email, securityConfig.getAccessTokenExpiry());
//
//            Thread thread = new Thread(() -> emailSenderService.sendEmail(email, "Verification", "A new Project has been assigned to you"+"\n http://localhost:4200/login?authTokens="+validationToken.value));
//            thread.start();

        return new EmployeeJobListView(employeeJobRepository.save(new EmployeeJob(form)));
    }

    @Override
    public EmployeeJobListView update(Integer jobId, EmployeeJobForm form) throws NotFoundException {
        return employeeJobRepository.findByJobId(jobId)
                .map((job) -> {
                    return new EmployeeJobListView(employeeJobRepository.save(job.update(form)));
                }).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<EmployeeJobListView> list() {
        return  StreamSupport.stream(employeeJobRepository
                .findAll().spliterator(), false)
                .map(jobs -> new EmployeeJobListView(jobs.getEmployee(),jobs.getProject()))
                .collect(Collectors.toList());
    }
}
