package com.project.controller;

import com.project.dto.UserRequestDTO;
import com.project.dto.UserRequestRegisterDTO;
import com.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class ProjectController {


    @Autowired
    private ProjectService service;

    @CrossOrigin
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> register(@Valid @RequestBody UserRequestRegisterDTO userRequestDTO){
        return service.accountRegister(userRequestDTO);
    }

    @CrossOrigin
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Object> login(@Valid @RequestBody UserRequestDTO userRequestDTO){
        return service.login(userRequestDTO);
    }

}
