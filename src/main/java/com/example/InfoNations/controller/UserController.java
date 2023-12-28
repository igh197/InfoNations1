package com.example.InfoNations.controller;

import com.example.InfoNations.entity.User;
import com.example.InfoNations.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @PostMapping("/user/new")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
    @PutMapping("/user/{id}")
    public User putUser(@RequestBody User user,@PathVariable Long id){
        return userService.putUser(user,id);
    }
    @DeleteMapping("/user/{id}")
    public void delUser(@PathVariable Long id){
        userService.delUser(id);
    }
}
