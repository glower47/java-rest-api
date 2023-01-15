package com.example.andreitrache.controller;

import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.model.Connection;
import com.example.andreitrache.repository.ConnectionRepository;
import com.example.andreitrache.service.ConnectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
@Tag(name = "Connection controller", description = "All connection related endpoints can be found here.")
public class ConnectionController {

    private final ConnectionService connectionService;
    private final ConnectionRepository connectionRepository;

    public ConnectionController(ConnectionService connectionService,
                                ConnectionRepository connectionRepository) {
        this.connectionService = connectionService;
        this.connectionRepository = connectionRepository;
    }
    @GetMapping
    @Operation(summary = "Get all connections", description = "This endpoint will return all the connections in the database.")
    public ResponseEntity<List<Connection>> getAllConnections() {
        List<Connection> connections = connectionService.getAllConnections();
        return new ResponseEntity<>(connections, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create a connection between 2 users", description = "This endpoint will create a connection between 2 users in the database.")
    public ResponseEntity<Connection> createConnection(@RequestBody Connection connection) {
        return ResponseEntity.ok(connectionService.createConnection(connection));
    }
    @GetMapping("/{userId}")
    @Operation(summary = "Retrieve a user's connections", description = "This endpoint will retrieve all connections that a specific user has.")
    public ResponseEntity<List<UserDto>> getUserConnections(@PathVariable Long userId) {
        List<UserDto> connections = connectionService.getConnectionsByUserId(userId);
        return new ResponseEntity<>(connections, HttpStatus.OK);
    }

    @DeleteMapping
    @Operation(summary = "Delete a connection between 2 users", description = "This endpoint will delete the connection between 2 users.")
    public ResponseEntity<Void> deleteConnection(@RequestBody Connection connection) {
        connectionService.deleteConnection(connection);
        return ResponseEntity.noContent().build();
    }

}

