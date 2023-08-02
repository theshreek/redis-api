package com.theshreek.redisserver.controller;

import com.theshreek.redisserver.entity.User;
import com.theshreek.redisserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUser() {
        return userService.getAllUser();
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam(name = "id") Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestParam(name = "id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<?> getByUserId(@RequestParam(name = "id") Long id) {
        return userService.getUserById(id);
    }
}
