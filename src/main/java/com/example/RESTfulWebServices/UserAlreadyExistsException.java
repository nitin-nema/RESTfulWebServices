package com.example.RESTfulWebServices;

import com.example.RESTfulWebServices.Model.User;

@PostMapping("/register")
public ResponseEntity<?> registerUser(@RequestBody User user) {
    if (users.containsKey(user.getEmail())) {
        throw new UserAlreadyExistsException("User with email already exists");
    }
    users.put(user.getEmail(), user);
    return ResponseEntity.ok("User registered successfully");
}
