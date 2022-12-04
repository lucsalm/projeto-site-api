package com.project.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityService {

    public static byte[] convertPassword(String input)  {
        try {
            return MessageDigest.getInstance("SHA-512").digest(input.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong");
        }
    }
}
