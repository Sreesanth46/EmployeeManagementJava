/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.employee.security.config;

import java.time.Duration;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author nirmal
 */
@Validated
public class SecurityConfig {

    /**
     * Password for the token generator - cannot be null and must be exactly 16
     * ASCII characters
     */
    @NotNull(message = "security.token-generator-password cannot be null")
    @Pattern(regexp = "[\\x00-\\x7F]{16}", message = "security.token-generator-password must be exactly 16 ASCII characters")
    private String tokenGeneratorPassword;

    /**
     * Salt for the token generator - cannot be null and must be exactly 16
     * digit hexadecimal
     */
    @NotNull(message = "security.token-generator-salt cannot be null")
    @Pattern(regexp = "[0-9A-Fa-f]{16}", message = "security.token-generator-password must be exactly 16 digit hexadecimal")
    private String tokenGeneratorSalt;

    /**
     * Duration for access token expiry
     */
    @NotNull
    private Duration accessTokenExpiry = Duration.ofMinutes(30);

    /**
     * Duration for refresh token expiry
     */
    @NotNull
    private Duration refreshTokenExpiry = Duration.ofDays(7);

    public String getTokenGeneratorPassword() {
        return tokenGeneratorPassword;
    }

    public void setTokenGeneratorPassword(String tokenGeneratorPassword) {
        this.tokenGeneratorPassword = tokenGeneratorPassword;
    }

    public String getTokenGeneratorSalt() {
        return tokenGeneratorSalt;
    }

    public void setTokenGeneratorSalt(String tokenGeneratorSalt) {
        this.tokenGeneratorSalt = tokenGeneratorSalt;
    }

    public Duration getAccessTokenExpiry() {
        return accessTokenExpiry;
    }

    public void setAccessTokenExpiry(Duration accessTokenExpiry) {
        this.accessTokenExpiry = accessTokenExpiry;
    }

    public Duration getRefreshTokenExpiry() {
        return refreshTokenExpiry;
    }

    public void setRefreshTokenExpiry(Duration refreshTokenExpiry) {
        this.refreshTokenExpiry = refreshTokenExpiry;
    }
}
