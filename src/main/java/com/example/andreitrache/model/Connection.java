package com.example.andreitrache.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "connection_id", insertable = false, updatable = false)
    private User connection;

    public User getConnection() {
        return connection;
    }

    public Connection() {
    }

    public Connection(User user, User connection) {
        this.user = user;
        this.connection = connection;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return user.getId();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getConnectionId() {
        return connection.getId();
    }

    public String getConnectionName() {
        return connection.getName();
    }

    public void setConnection(User connection) {
        this.connection = connection;
    }
}
