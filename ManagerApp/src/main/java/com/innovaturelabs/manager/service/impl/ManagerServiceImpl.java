package com.innovaturelabs.manager.service.impl;

import com.innovaturelabs.common.entity.Manager;
import com.innovaturelabs.manager.exception.BadRequestException;
import com.innovaturelabs.common.form.LoginForm;
import com.innovaturelabs.common.form.ManagerForm;
import com.innovaturelabs.common.repository.ManagerRepository;
import com.innovaturelabs.manager.exception.NotFoundException;
import com.innovaturelabs.manager.security.config.SecurityConfig;
import com.innovaturelabs.manager.security.util.InvalidTokenException;
import com.innovaturelabs.manager.security.util.SecurityUtil;
import com.innovaturelabs.manager.security.util.TokenExpiredException;
import com.innovaturelabs.manager.security.util.TokenGenerator;
import com.innovaturelabs.manager.security.util.TokenGenerator.Token;
import com.innovaturelabs.manager.service.ManagerService;
import com.innovaturelabs.manager.view.LoginView;
import com.innovaturelabs.manager.view.ManagerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import com.innovaturelabs.manager.security.util.TokenGenerator.Status;


import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import static com.innovaturelabs.manager.security.AccessTokenUserDetailsService.PURPOSE_ACCESS_TOKEN;

/**
 *
 * @author Sreesanth
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Value("${client.id}")
    private String client_Id;

    @Value("${client.secret}")
    private String client_secret;

    @Value("${grant.type.code}")
    private String grant_type;

    @Value("${redirect.uri}")
    private String redirect_uri;

    private static final String PURPOSE_REFRESH_TOKEN = "REFRESH_TOKEN";
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private SecurityConfig securityConfig;


    private static BadRequestException badRequestException() {
        return new BadRequestException("Invalid credentials");
    }

    // private static BadRequestException userNotVerifiedException() {
    //     return new BadRequestException("Please verify your Email address");
    // }


    @Override
    public ManagerView add(@Valid ManagerForm form) {

        return new ManagerView(managerRepository.save(new Manager(
            form.getName(), 
            form.getEmail(), 
            passwordEncoder.encode(form.getPassword())
        )));
    }

    @Override
    public ManagerView currentUser() {
        return new ManagerView(managerRepository.findById(SecurityUtil.getCurrentUserId()).orElseThrow(NotFoundException::new));
    }

    @Override
    public LoginView login(LoginForm form, Errors errors) throws BadRequestException {
        if (errors.hasErrors()) {
            throw badRequestException();
        }
        Manager manager = managerRepository.findByEmail(form.getEmail()).orElseThrow(ManagerServiceImpl::badRequestException);
        if(!passwordEncoder.matches(form.getPassword(), manager.getPassword())) {
            throw badRequestException();
        }

        return generateToken(manager);
    }

    @Override
    public LoginView googleLogin(String code) throws BadRequestException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .header("accept", "application/json")
                .uri(URI.create("https://oauth2.googleapis.com/token?client_id="+ client_Id +"&client_secret="+ client_secret +"&code=" + code + "&grant_type="+ grant_type +"&redirect_uri=" +redirect_uri))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject object;
        String id_token;
        String email;
        String name;
        String picture;
        String password = "Sreesanth@46";
        try {
            object = new JSONObject(response.body());
            id_token = object.getString("id_token");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request2 = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.noBody())
                .header("accept", "application/json")
                .uri(URI.create("https://oauth2.googleapis.com/tokeninfo?id_token=" + id_token))
                .build();
        HttpResponse<String> response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
        JSONObject object2;
        try {
            object2 = new JSONObject(response2.body());
            email = object2.getString("email");
            name = object2.getString("name");
            picture = object2.getString("picture");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        Optional<Manager> manager = managerRepository.findByEmail(email);

        if(manager.isEmpty()) {
            managerRepository.save(new Manager(name, email, passwordEncoder.encode(password), picture));
            Manager newManager = managerRepository.findByEmail(email).orElseThrow(ManagerServiceImpl::badRequestException);
            return generateToken(newManager);
        }
        else {
            return generateToken(manager.get());
        }
    }

    @Override
    public LoginView refresh(String refreshToken) throws BadRequestException {
        Status status;
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

        Manager manager = managerRepository.findByManagerIdAndPassword(userId, password).orElseThrow(ManagerServiceImpl::badRequestException);

        String id = String.format("%010d", manager.getManagerId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        return new LoginView(
                manager,
                new LoginView.TokenView(accessToken.value, accessToken.expiry),
                new LoginView.TokenView(refreshToken, status.expiry)
        );
    }

    private static BadRequestException userNotVerifiedException() {
        return new BadRequestException("Please verify your Email address");
    }

    public LoginView generateToken(Manager manager) {
        String id = String.format("%010d", manager.getManagerId());
        Token accessToken = tokenGenerator.create(PURPOSE_ACCESS_TOKEN, id, securityConfig.getAccessTokenExpiry());
        Token refreshToken = tokenGenerator.create(PURPOSE_REFRESH_TOKEN, id + manager.getPassword(), securityConfig.getRefreshTokenExpiry());

        return new LoginView(manager, accessToken, refreshToken);
    }
}
