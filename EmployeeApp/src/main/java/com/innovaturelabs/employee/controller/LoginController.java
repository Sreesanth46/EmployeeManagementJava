package com.innovaturelabs.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.innovaturelabs.common.form.LoginForm;
import com.innovaturelabs.employee.service.EmployeeService;
import com.innovaturelabs.employee.view.EmployeeView;
import com.innovaturelabs.employee.view.LoginView;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public EmployeeView currentUser() {
        return employeeService.currentUser();
    }

    @PostMapping
    public LoginView login(@Valid @RequestBody LoginForm form, Errors errors) {
        return employeeService.login(form, errors);
    }

    @PutMapping
    public LoginView refresh(@RequestBody String refreshToken) {
        return employeeService.refresh(refreshToken);
    }

    
}
