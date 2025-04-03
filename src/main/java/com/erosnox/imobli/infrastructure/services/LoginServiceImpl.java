package com.erosnox.imobli.infrastructure.services;

import com.erosnox.imobli.core.auth.application.contracts.services.LoginService;
import com.erosnox.imobli.core.auth.domain.models.request.LoginRequest;
import com.erosnox.imobli.core.auth.domain.models.response.LoginResponse;
import com.erosnox.imobli.infrastructure.config.authorization.TokenService;
import com.erosnox.imobli.infrastructure.persistence.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                request.email(), request.password());

        var auth = this.authenticationManager.authenticate(usernamePassword);
        var user = (UserEntity) auth.getPrincipal();

        Map<String, Object> tokenResponse = this.tokenService
                .generateToken(user);

        var token = (String) tokenResponse.get("token");

        return new LoginResponse(token, user.getId());
    }
}
