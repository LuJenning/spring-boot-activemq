package com.example.mqdemo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Getter
@Setter
@ToString
@Builder
@Entity
@AllArgsConstructor
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private String email;

    public User(){}

}
