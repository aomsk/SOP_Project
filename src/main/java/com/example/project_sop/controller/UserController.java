package com.example.project_sop.controller;

import com.example.project_sop.pojo.User;
import com.example.project_sop.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser/{username}/{email}/{password}", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@PathVariable("username") String username,
                                        @PathVariable("email") String email,
                                        @PathVariable("password") String password) {
        User user = userService.createUser(new User(null, username, email, password));
        return ResponseEntity.ok(user);
    }
}
