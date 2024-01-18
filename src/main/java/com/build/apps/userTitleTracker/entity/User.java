package com.build.apps.userTitleTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private  int userId;
    private  int id;
    private String title;
    private boolean completed;
}
