package com.project.service;

import com.project.dto.UserRequestDTO;
import com.project.dto.UserRequestRegisterDTO;
import com.project.mapper.UserMapper;
import com.project.model.User;
import com.project.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.UUID;

@Slf4j
@Service
public class ProjectService {

    @Autowired
    private UserRepository userRepository;

    public Mono<Object> accountRegister(UserRequestRegisterDTO userRequestDTO) {
        User user = UserMapper.toUser(userRequestDTO);
        return Mono.just(userRepository.existsByEmail(user.getEmail()))
                .flatMap(exists->{
                    if (!exists) {
                        userRepository.save(user);
                        log.info("Success to create user: [{}]",user.getEmail());
                        return Mono.empty();
                    }
                    log.info("Already exists user: [{}]",user.getEmail());
                    return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT));
                })
                .onErrorResume(throwable -> {
                    log.error("Error while creating: ",throwable);
                    if(throwable instanceof ResponseStatusException){
                        return Mono.error(throwable);
                    }
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
                });

    }

    public Mono<Object> login(UserRequestDTO userRequestDTO){
        User user = UserMapper.toUser(userRequestDTO);
        return Mono.just(userRepository.existsByEmail(user.getEmail()))
                .flatMap(exists ->{
                    if(exists) {
                        User userResponse = userRepository.findByEmail(user.getEmail());
                        if(Arrays.equals(userResponse.getPassword(), user.getPassword())){
                            log.info("Success to login user: [{}]",user.getEmail());
                            return Mono.empty();
                        }
                        log.info("Incorrect password: [{}]",user.getEmail());
                        return Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED));
                    }
                    log.info("Not found user [{}]",user.getEmail());
                    return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND));
                })
                .onErrorResume(throwable -> {
                    log.error("Error while login: ",throwable);
                    if(throwable instanceof ResponseStatusException){
                        return Mono.error(throwable);
                    }
                    return Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
                });
    }


}
