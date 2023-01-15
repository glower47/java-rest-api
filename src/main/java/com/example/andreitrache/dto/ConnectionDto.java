package com.example.andreitrache.dto;

import com.example.andreitrache.model.Connection;

public class ConnectionDto {
    private Long id;
    private Long userId;
    private Long connectionUserId;
    private String connectionName;

    public ConnectionDto(Connection connection, String connectionName) {
        this.id = connection.getId();
        this.userId = connection.getUserId();
        this.connectionUserId = connection.getConnectionId();
        this.connectionName = connectionName;
    }

    //getters and setters
}