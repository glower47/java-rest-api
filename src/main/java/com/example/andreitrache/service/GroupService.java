package com.example.andreitrache.service;

import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.model.Group;
import com.example.andreitrache.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    List<Group> getAllGroups();
    List<UserDto> getMembersOfGroup(Long groupId);
    void removeUserFromGroup(Long groupId, Long userId);
}
