package com.unauthorizeddeliveries.controller;

import com.unauthorizeddeliveries.services.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/putLoginDataToDB")
    public ResponseEntity<HttpStatus> putLoginDataToDataBase(){

        loginService.putLoginsToDB();

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
