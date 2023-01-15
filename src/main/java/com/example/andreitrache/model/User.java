package com.example.andreitrache.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String profilePicture;
    private String headline;
    private String summary;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Connection> connections;

    @OneToMany(mappedBy = "connection",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Connection> connectionWith;

    public User() {
    }

    public User(String name, String email, String password, String profilePicture, String headline, String summary) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profilePicture = profilePicture;
        this.headline = headline;
        this.summary = summary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public List<Connection> getConnectionWith() {
        return connectionWith;
    }
}
