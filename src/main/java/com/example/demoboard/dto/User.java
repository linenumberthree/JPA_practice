package com.example.demoboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="user")
public class User {
    @Id
    private long id;
    private String userName;
    private String userId;
    private String password;
}
