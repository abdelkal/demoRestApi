package be.unit.demo.controller;

import be.unit.demo.security.model.AuthenticationRequest;
import be.unit.demo.security.model.AuthenticationResponse;
import be.unit.demo.security.service.JwtUtil;
import be.unit.demo.security.model.UserPrincipal;
import be.unit.demo.security.service.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    UserPrincipalDetailsService userPrincipalDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    /*
    If the user is successfully authenticated (via JPA), a token is generated and sent to the user
     */
    @PostMapping(path = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorrect username or password");
        }

        final UserPrincipal userPrincipal = userPrincipalDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userPrincipal);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}
