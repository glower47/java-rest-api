package com.example.andreitrache.controller;

import com.example.andreitrache.dto.ConnectionDto;
import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.model.Connection;
import com.example.andreitrache.repository.ConnectionRepository;
import com.example.andreitrache.service.ConnectionService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connections")
public class ConnectionController {

    private final ConnectionService connectionService;
    private final ConnectionRepository connectionRepository;

    public ConnectionController(ConnectionService connectionService,
                                ConnectionRepository connectionRepository) {
        this.connectionService = connectionService;
        this.connectionRepository = connectionRepository;
    }

    @PostMapping
    public Connection createConnection(@RequestBody Connection connection) {
        return connectionService.createConnection(connection);
    }

    @GetMapping
    public ResponseEntity<List<Connection>> getAllConnections() {
        List<Connection> connections = connectionService.getAllConnections();
        return new ResponseEntity<>(connections, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserDto>> getUserConnections(@PathVariable Long userId) {
        List<UserDto> connections = connectionService.getConnectionsByUserId(userId);
        return new ResponseEntity<>(connections, HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteConnection(@RequestBody Connection connection) {
        connectionService.deleteConnection(connection);
    }

}

