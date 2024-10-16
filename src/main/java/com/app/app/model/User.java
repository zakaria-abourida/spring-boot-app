package com.app.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;

    private String password;

    // Constructeur par défaut
    public User() {
    }

    // Constructeur avec paramètres
    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters et Setters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
