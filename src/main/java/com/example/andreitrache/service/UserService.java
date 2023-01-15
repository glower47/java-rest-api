package com.example.andreitrache.service;

import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);
    User getUser(Long id);
    List<UserDto> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);

}
