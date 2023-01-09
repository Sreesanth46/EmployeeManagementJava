package com.innovaturelabs.manager.service;


import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.common.form.LoginForm;
import com.innovaturelabs.common.form.ManagerForm;
import com.innovaturelabs.manager.view.LoginView;
import com.innovaturelabs.manager.view.ManagerView;
import org.springframework.validation.Errors;

import javax.validation.Valid;
import java.io.IOException;

/**
 *
 * @author Sreesanth
 */
public interface ManagerService {

    ManagerView add(@Valid ManagerForm form);

    ManagerView currentUser();

    LoginView login(LoginForm form, Errors errors) throws BadRequestException;

    LoginView googleLogin(String code) throws BadRequestException, IOException, InterruptedException;


    LoginView refresh(String refreshToken) throws BadRequestException;

}
