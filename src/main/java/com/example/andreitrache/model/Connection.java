package com.example.andreitrache.model;

import jakarta.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "connection_id")
    private User connection;

    public Connection() {
    }

    public Connection(User user, User connection) {
        this.user = user;
        this.connection = connection;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getConnection() {
        return connection;
    }

    public void setConnection(User connection) {
        this.connection = connection;
    }
}
