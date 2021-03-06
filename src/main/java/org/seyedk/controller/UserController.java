/*
 * Copyright (c) 2018. Developed by Seyed Ketabchi on 9/9/18 2:14 PM. Last Modified 9/3/18 8:51 PM. Please use as is under your own discretion.
 */

package org.seyedk.controller;

import org.seyedk.domain.User;
import org.seyedk.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable("id") Long id){
        User user = userRepository.findUserById(id);
        System.out.println("User name : "+ user.toString());
        return user;
    }
}
