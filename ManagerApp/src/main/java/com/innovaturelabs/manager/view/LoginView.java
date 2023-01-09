package com.innovaturelabs.manager.view;

import com.innovaturelabs.common.entity.Manager;
import com.innovaturelabs.manager.json.Json;
import com.innovaturelabs.manager.security.util.TokenGenerator.Token;

import java.util.Date;

/**
 *
 * @author Sreesanth
 */
public class LoginView extends ManagerView {
    public static class TokenView {
        
        private final String value;
        @Json.DateTimeFormat
        private final Date expiry;

        public TokenView(Token token) {
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

    public LoginView(Manager manager, Token accessToken, Token refreshToken) {
        super(manager);
        this.accessToken = new TokenView(accessToken);
        this.refreshToken = new TokenView(refreshToken);
    }

     public LoginView(Manager manager, TokenView accessToken, TokenView refreshToken) {
         super(manager);
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
