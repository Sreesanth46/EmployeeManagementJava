package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.form.EmployeeForm;
import com.innovaturelabs.common.repository.DetailRepository;
import com.innovaturelabs.common.repository.EmployeeRepository;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.security.config.SecurityConfig;
import com.innovaturelabs.manager.security.util.SecurityUtil;
import com.innovaturelabs.manager.security.util.TokenGenerator;
import com.innovaturelabs.manager.service.EmailSenderService;
import com.innovaturelabs.manager.service.EmployeeService;
import com.innovaturelabs.manager.view.DetailsListView;
import com.innovaturelabs.manager.view.EmployeeDetailView;
import com.innovaturelabs.manager.view.EmployeeListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Sreesanth
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public EmployeeDetailView addEmployee(@Valid EmployeeForm form) {
        Employee employee = new Employee(
                form.getEmployeeName(),
                form.getEmployeeEmail(),
                passwordEncoder.encode(form.getPassword()),
                SecurityUtil.getCurrentUserId()
        );

        employee.setLoginCount(0);
//        if(employee.getLoginCount() == 0) {
//            String email = form.getEmployeeEmail();
//            String otp = form.getPassword();
//            TokenGenerator.Token validationToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, email, securityConfig.getAccessTokenExpiry());
//
//            Thread thread = new Thread(() -> emailSenderService.sendEmail(email, "Verification",
//                    "http://localhost:4200/login?authTokens=" +validationToken.value+ "\n Use Email : "+ email + "\n One time password : " +otp));
//            thread.start();
//        }
        return new EmployeeDetailView(employeeRepository.save(employee));
    }

    @Override
    @Transactional
    public EmployeeDetailView update(Integer employeeId, @Valid EmployeeForm form) throws NotFoundException {
        return employeeRepository.findByEmployeeId(employeeId)
                .map((employee) -> {
                    return new EmployeeDetailView(employeeRepository.save(employee.update(form)));
                }).orElseThrow(NotFoundException::new);
    }
    @Override
    public List<EmployeeListView> list() {

        return employeeRepository
        .findAll().stream()
        .map(EmployeeListView::new)
        .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeListView> sortASC() {

        return employeeRepository
                        .findAllOrderByEmployeeNameAsc().stream()
                .map(EmployeeListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeListView> sortDESC() {

        return employeeRepository
                        .findAllOrderByEmployeeNameDesc().stream()
                .map(EmployeeListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeListView> sortByIdAsc() {

        return employeeRepository
                        .findAllOrderByEmployeeIdAsc().stream()
                .map(EmployeeListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeListView> sortByIdDesc() {

        return employeeRepository
                        .findAllOrderByEmployeeIdDesc().stream()
                .map(EmployeeListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return employeeRepository.count();
    }

    @Override
    public List<DetailsListView> getDetails(Integer employeeId) {
        try {
            return detailRepository.findAllByEmployeeEmployeeId(employeeId).stream()
                    .map(DetailsListView::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new NotFoundException("Details for employeeId " + employeeId + " not found");
        }
    }

    @Override
    public EmployeeDetailView softDelete(Integer employeeId) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(NotFoundException::new);
        employee.setStatus(Employee.Status.INACTIVE.value);
        return new EmployeeDetailView(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeListView> getSoftDeleteEmployee() {
        return this.employeeRepository.findAllByStatus(Employee.Status.INACTIVE.value).stream()
                .map(EmployeeListView::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeListView> getActiveEmployees() {
        return this.employeeRepository.findAllByStatus(Employee.Status.ACTIVE.value).stream()
                .map(EmployeeListView::new)
                .collect(Collectors.toList());
    }
}
