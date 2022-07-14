package com.example.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Users")

//#@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String userName;
    private String userRole;
    private String password;

}
