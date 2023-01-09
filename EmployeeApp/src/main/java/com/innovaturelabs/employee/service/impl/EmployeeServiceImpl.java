package com.innovaturelabs.employee.service.impl;


import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.form.ForgotPassword;
import com.innovaturelabs.common.form.ForgotPasswordMailForm;
import com.innovaturelabs.employee.exception.BadRequestException;
import com.innovaturelabs.employee.exception.NotFoundException;
import com.innovaturelabs.common.form.EmployeeForm;
import com.innovaturelabs.common.form.LoginForm;
import com.innovaturelabs.common.form.ResetPasswordForm;
import com.innovaturelabs.common.repository.EmployeeRepository;
import com.innovaturelabs.employee.security.config.SecurityConfig;
import com.innovaturelabs.employee.security.util.InvalidTokenException;
import com.innovaturelabs.employee.security.util.SecurityUtil;
import com.innovaturelabs.employee.security.util.TokenExpiredException;
import com.innovaturelabs.employee.security.util.TokenGenerator;
import com.innovaturelabs.employee.service.EmailSenderService;
import com.innovaturelabs.employee.service.EmployeeService;
import com.innovaturelabs.employee.view.EmployeeView;
import com.innovaturelabs.employee.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import com.innovaturelabs.employee.security.util.TokenGenerator.Token;
import com.innovaturelabs.employee.security.util.TokenGenerator.Status;
import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.innovaturelabs.employee.security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;



@Service
public class EmployeeServiceImpl implements EmployeeService {

private static final String PURPOSE_REFRESH_TOKEN ="REFRESH_TOKEN";
@Autowired
private EmployeeRepository employeeRepository;

@Autowired 
private PasswordEncoder passwordEncoder;

@Autowired
private TokenGenerator tokenGenerator;

@Autowired
private SecurityConfig securityConfig;

@Autowired
private EmailSenderService emailSenderService;


@Override
public EmployeeView reset(ResetPasswordForm form) {
    Employee employee=employeeRepository.findByEmployeeId(SecurityUtil.getCurrentUserId()).orElseThrow(NotFoundException::new);
    employee.setPassword(passwordEncoder.encode(form.getPassword()));
    employeeRepository.save(employee);
    return new EmployeeView(employee);
}

@Override
public EmployeeView forgotPassword(ForgotPasswordMailForm form){
    Employee employee=employeeRepository.findByEmployeeEmail(form.getEmployeeEmail()).orElseThrow(NotFoundException::new);
    String mail=employee.getEmployeeEmail();
    Token accessToken=tokenGenerator.create(PURPOSE_ACCESS_TOKEN,mail,securityConfig.getAccessTokenExpiry());
    String tok=accessToken.value;
    System.out.println("http://localhost:4200/forgotPassword?at="+tok);

//            Thread thread = new Thread(() -> emailSenderService.sendEmail(mail, "Reset Password",
//                    "http://localhost:4200/forgotPassword?at="+tok));
//            thread.start();
    return null;
}

@Override
public EmployeeView newPassword(ForgotPassword form,String token){
    Status status;
    status=tokenGenerator.verify(PURPOSE_ACCESS_TOKEN,token );
    String mail=status.data.substring(0);
    Employee employee=employeeRepository.findByEmployeeEmail(mail).orElseThrow(NotFoundException::new);
    employee.setPassword(passwordEncoder.encode(form.getPassword()));
    employee.setLoginCount(employee.getLoginCount() + 1);
    employeeRepository.save(employee);
    return new EmployeeView(employee);
}

@Override
@Transactional
public EmployeeView updateEmployee(Integer employeeId, EmployeeForm form)
{ Employee employee=employeeRepository.findByEmployeeId(SecurityUtil.getCurrentUserId()).orElseThrow(NotFoundException::new);
   employee.setEmployeeName(form.getEmployeeName());
   employee.setEmployeeEmail(form.getEmployeeEmail());
   return new EmployeeView(employee);
}

@Override
    public LoginView login(LoginForm form, Errors errors) throws BadRequestException {
        if (errors.hasErrors()) {
            throw badRequestException();
        }
        Employee employee = employeeRepository.findByEmployeeEmail(form.getEmail()).orElseThrow(EmployeeServiceImpl::badRequestException);
        if (!passwordEncoder.matches(form.getPassword(), employee.getPassword())) {
            throw badRequestException();
        }
        employee.setLoginCount(employee.getLoginCount()+1);
        employeeRepository.save(employee);
        String id = String.format("%010d", employee.getEmployeeId());
        TokenGenerator.Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        TokenGenerator.Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + employee.getPassword(), securityConfig.getRefreshTokenExpiry());
        return new LoginView(employee, accessToken, refreshToken);
    }
    private static BadRequestException badRequestException() {
        return new BadRequestException("Invalid credentials");
    }
    @Override
    public LoginView refresh(String refreshToken) throws BadRequestException {
        TokenGenerator.Status status;
        try {
            status = tokenGenerator.verify(PURPOSE_REFRESH_TOKEN, refreshToken);
        } catch (InvalidTokenException e) {
            throw new BadRequestException("Invalid token", e);
        } catch (TokenExpiredException e) {
            throw new BadRequestException("Token expired", e);
        }

        int userId;
        try {
            userId = Integer.parseInt(status.data.substring(0, 10));
        } catch (NumberFormatException e) {
            throw new BadRequestException("Invalid token", e);
        }

        String password = status.data.substring(10);

        Employee employee = employeeRepository.findByEmployeeIdAndPassword(userId, password).orElseThrow(EmployeeServiceImpl::badRequestException);

        String id = String.format("%010d", employee.getEmployeeId());
        TokenGenerator.Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        return new LoginView(
                employee,
                new LoginView.TokenView(accessToken.value, accessToken.expiry),
                new LoginView.TokenView(refreshToken, status.expiry)
        );
    }
    @Override
    public EmployeeView currentUser() {
        return new EmployeeView(
                employeeRepository.findByEmployeeId(SecurityUtil.getCurrentUserId()).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public List<EmployeeView> list() {
        return StreamSupport.stream(employeeRepository.findByEmployeeId(SecurityUtil.getCurrentUserId()).stream().spliterator(), false
                ).map(employee1 -> new EmployeeView(employee1))
                .collect(Collectors.toList());

    }

   
}
