package com.innovaturelabs.manager.controller;

import com.innovaturelabs.common.form.LoginForm;
import com.innovaturelabs.manager.service.ManagerService;
import com.innovaturelabs.manager.view.LoginView;
import com.innovaturelabs.manager.view.ManagerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author Sreesanth
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ManagerService managerService;

    @PostMapping
    public LoginView login(@Valid @RequestBody LoginForm form, Errors errors) {
        return managerService.login(form, errors);
    }

    @GetMapping("/google")
    public LoginView googleLogin(@RequestHeader(value = "code")String code) throws Exception {
        return managerService.googleLogin(code);
    }

    @PutMapping
    public LoginView refresh(@RequestBody String refreshToken) {
        return managerService.refresh(refreshToken);
    }

    @GetMapping
    public ManagerView currentUser() {
        return managerService.currentUser();
    }
}
