package com.SSS.EmailSender.JWT_Controller;



import com.SSS.EmailSender.JWT_Model.LoginDTO;
import com.SSS.EmailSender.JWT_Model.LoginResponseDTO;
import com.SSS.EmailSender.JWT_Service.JwtHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/server")
public class LoginAuthenticateController {

    private UserDetailsService userDetailsService;

    private AuthenticationManager manager;

    private JwtHelper helper;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO request) {


        this.doAuthenticate(request.getId(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getId());
        String token = this.helper.generateToken(userDetails);


        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credentials Invalid !!");
        }

    }
}