package com.app.app.controller;

import com.app.app.model.LoginRequest;
import com.app.app.model.User;
import com.app.app.service.UserService;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService; // Injection du service

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // // Utilisation du UserService pour valider les informations de connexion
        // if (userService.authenticateUser(loginRequest.getUsername(),
        // loginRequest.getPassword())) {
        // return "Login successful!";
        // } else {
        // return "Invalid credentials!";
        // }

        return "Invalid credentials!";
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {

        List<User> users = userService.getUsers();

        ApiResponse<List<User>> response = new ApiResponse("succes", HttpStatus.CREATED.value(), users);

        // Return the response as JSON
        return ResponseEntity.ok().body(response);

    }

    @PostMapping("/users")
    public ResponseEntity<ApiResponse<User>> addUser(@Valid @RequestBody User user) {
        User newUser = userService.addUser(user);
        ApiResponse<User> response = new ApiResponse<>("User added successfully",
                HttpStatus.CREATED.value(), newUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(user);
    }

}
