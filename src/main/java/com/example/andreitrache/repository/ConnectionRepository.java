package com.example.andreitrache.repository;

import com.example.andreitrache.model.Connection;
import com.example.andreitrache.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository <Connection, Long> {
    List<Connection> findByUser(User user);
    List<Connection> findByConnection(User connection);

}
