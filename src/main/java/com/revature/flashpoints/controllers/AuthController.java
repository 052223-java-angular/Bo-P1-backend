package com.revature.flashpoints.controllers;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.flashpoints.dtos.requests.NewLoginRequest;
import com.revature.flashpoints.dtos.requests.NewUserRequest;
import com.revature.flashpoints.dtos.responses.Principal;
import com.revature.flashpoints.services.JwtTokenService;
import com.revature.flashpoints.services.UserService;
import com.revature.flashpoints.utils.custom_exceptions.ResourceConflictException;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtTokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody NewUserRequest req) {
            if (!userService.isValidUsername(req.getUsername())) {
                throw new ResourceConflictException("Username needs to be 8-20 characters long and can only contain letters, numbers, periods, and underscores");
            }

            if (!userService.isUniqueUsername(req.getUsername())) {
                throw new ResourceConflictException("Username is not unique!");
            }

            if (!userService.isValidPassword(req.getPassword())) {
                throw new ResourceConflictException("Password needs to be at least 8 characters long and contain at least one letter or number!");
            }

            if (!userService.isValidEmail(req.getEmail())) {
                throw new ResourceConflictException("Email is not a valid email address!");
            }

            if (!userService.isSamePassword(req.getPassword(), req.getConfirmPassword())) {
                throw new ResourceConflictException("The inputted passwords do not match!");
            }

            userService.registerUser(req);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    @PostMapping("/login")
    public ResponseEntity<Principal> login(@RequestBody NewLoginRequest req) {
        Principal principal = userService.login(req);
        String token = tokenService.generateToken(principal);
        principal.setToken(token);

        return ResponseEntity.status(HttpStatus.OK).body(principal);
    }
}

