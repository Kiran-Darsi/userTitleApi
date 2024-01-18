package com.build.apps.userTitleTracker.service;

import com.build.apps.userTitleTracker.util.FileUtil;
import com.build.apps.userTitleTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Value("${api.endpoint}")
    private String apiUrl;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<String> getAllUserTitles() {
        ResponseEntity<User[]> responseEntity =
                restTemplate.getForEntity(apiUrl, User[].class);
        User[] userArray = responseEntity.getBody();

        List<String> userTitles =  Arrays.stream(userArray)
                .map(User::getTitle)
                .collect(Collectors.toList());
        FileUtil.writeListToFile(userTitles, "output.txt");
        // Process the result or return it
        return userTitles;
    }
}
