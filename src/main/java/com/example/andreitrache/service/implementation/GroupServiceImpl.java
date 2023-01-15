package com.example.andreitrache.service.implementation;

import com.example.andreitrache.Constants;
import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.exception.GroupException;
import com.example.andreitrache.exception.UserException;
import com.example.andreitrache.model.Group;
import com.example.andreitrache.model.User;
import com.example.andreitrache.repository.ConnectionRepository;
import com.example.andreitrache.repository.GroupRepository;
import com.example.andreitrache.service.GroupService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = groupRepository.findAll();

        if( groups.isEmpty() ) {
            throw new GroupException(Constants.NO_GROUPS_FOUND);
        }

        return groups;
    }
    @Override
    public List<UserDto> getMembersOfGroup(Long groupId) {

        Optional<Group> group = groupRepository.findById(groupId);
        if( group.isEmpty() ) {
            throw new GroupException(Constants.NO_GROUP);
        }

        List<User> users = groupRepository.findUsersByGroupId(groupId);

        if( users.isEmpty() ) {
            throw new GroupException(Constants.NO_MEMBERS_FOUND);
        }

        List<UserDto> userDtos = users.stream().map(u -> UserDto.fromUser(u)).collect(Collectors.toList());

        return userDtos;
    }
    @Transactional
    @Override
    public void removeUserFromGroup(Long groupId, Long userId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if( group.isEmpty() ) {
            throw new GroupException(Constants.NO_GROUP);
        }

        groupRepository.removeUserFromGroup(groupId, userId);
    }

}
