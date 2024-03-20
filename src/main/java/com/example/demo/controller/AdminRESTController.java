package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class AdminRESTController {
    private final UserService userService;

    @Autowired
    public AdminRESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping()
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {
        userService.createUser(user, user.getRoles());
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PutMapping()
    public ResponseEntity<List<User>> updateUser(@RequestBody User user) {
        if (user.getPassword() == null)
            user.setPassword(userService.getUserById(user.getId()).getPassword());
        userService.editUser(user, user.getRoles());
        return ResponseEntity.ok(userService.getAllUser());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<User>> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(userService.getAllUser());
    }
}
