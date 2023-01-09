package com.innovaturelabs.employee.view;

import com.innovaturelabs.common.entity.Employee;
import com.innovaturelabs.common.json.Json;
import com.innovaturelabs.employee.security.util.TokenGenerator;


import java.sql.Date;


public class LoginView extends EmployeeView{
    public static class TokenView {

        private final String value;
        @Json.DateTimeFormat
        private final Date expiry;

        public TokenView(TokenGenerator.Token token) {
            this.value = token.value;
            this.expiry = new Date(token.expiry);
        }

        public TokenView(String value, long expiry) {
            this.value = value;
            this.expiry = new Date(expiry);
        }

        public String getValue() {
            return value;
        }

        public Date getExpiry() {
            return expiry;
        }
    }

    private final TokenView accessToken;
    private final TokenView refreshToken;

    public LoginView(Employee employee, TokenGenerator.Token accessToken, TokenGenerator.Token refreshToken) {
        super(employee);
        this.accessToken = new TokenView(accessToken);
        this.refreshToken = new TokenView(refreshToken);
    }

    public LoginView(Employee employee, TokenView accessToken, TokenView refreshToken) {
        super(employee);
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public TokenView getAccessToken() {
        return accessToken;
    }

    public TokenView getRefreshToken() {
        return refreshToken;
    }
}
