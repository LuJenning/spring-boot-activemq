package com.example.mqdemo.controller;

import com.example.mqdemo.entity.User;
import com.example.mqdemo.service.ProviderService;
import com.example.mqdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activemq")
public class MQController {
    @Autowired
    private ProviderService providerService;

    @Autowired
    private UserService userService;

    @GetMapping("/{message}")
    public String send(@PathVariable String message) {
        providerService.sendMsg(message);
        return "SUCCESS";
    }

    @GetMapping("/user/{id}/{username}/{age}/{email}")
    public User send(@PathVariable("id") Long id,
                     @PathVariable("username") String username,
                     @PathVariable("age") Integer age,
                     @PathVariable("email") String email) {
        User user = User.builder().id(id).username(username).age(age).email(email).build();
        userService.sendUser(user);
        return user;
    }
}