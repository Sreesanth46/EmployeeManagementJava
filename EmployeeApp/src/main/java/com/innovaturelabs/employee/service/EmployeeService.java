package com.innovaturelabs.employee.service;


import org.springframework.validation.Errors;


import com.innovaturelabs.common.form.EmployeeForm;
import com.innovaturelabs.common.form.LoginForm;
import com.innovaturelabs.common.form.ResetPasswordForm;
import com.innovaturelabs.employee.exception.BadRequestException;
import com.innovaturelabs.employee.exception.NotFoundException;
import com.innovaturelabs.employee.view.EmployeeView;
import com.innovaturelabs.common.form.ForgotPassword;
import com.innovaturelabs.common.form.ForgotPasswordMailForm;
import com.innovaturelabs.employee.view.LoginView;

import java.util.List;

public interface EmployeeService {
 
    EmployeeView reset(ResetPasswordForm form);

    EmployeeView updateEmployee(Integer employeeId, EmployeeForm form) throws NotFoundException;

    LoginView login(LoginForm form, Errors errors) throws BadRequestException;

    LoginView refresh(String refreshToken) throws BadRequestException;

    EmployeeView currentUser();

    List<EmployeeView> list();

    EmployeeView forgotPassword(ForgotPasswordMailForm form);

    EmployeeView newPassword(ForgotPassword form,String token);

}
