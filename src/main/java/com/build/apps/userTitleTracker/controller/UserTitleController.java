package com.build.apps.userTitleTracker.controller;

import com.build.apps.userTitleTracker.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTitleController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/userTitles")
    public List<String> getAllUsers() {
        return userServiceImpl.getAllUserTitles();
    }

}
