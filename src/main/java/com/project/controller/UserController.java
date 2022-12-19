package com.project.controller;

import com.project.dto.request.user.UserRequestDTO;
import com.project.dto.request.user.UserRequestRegisterDTO;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> register(@Valid @RequestBody UserRequestRegisterDTO userRequestDTO){
        return service.accountRegister(userRequestDTO);
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Object> login(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return service.login(userRequestDTO);
    }

}
