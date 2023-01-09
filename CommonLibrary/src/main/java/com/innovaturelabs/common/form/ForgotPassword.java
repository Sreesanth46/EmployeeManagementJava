package com.innovaturelabs.common.form;

import com.innovaturelabs.common.form.validaton.Password;

import javax.validation.constraints.Size;

public class ForgotPassword {

    @Size(max = 255)
    @Password
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
