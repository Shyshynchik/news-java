package com.newsline.newsline.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    @Size(min=5, message = "Не меньше 5 знаков")
    private String login;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min=5, message = "Не меньше 5 знаков")
    private String password;

    @Column(name = "token")
    private String token;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

}
