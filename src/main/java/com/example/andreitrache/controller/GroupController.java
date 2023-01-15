package com.example.andreitrache.controller;

import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.model.Group;
import com.example.andreitrache.repository.GroupRepository;
import com.example.andreitrache.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    private final GroupRepository groupRepository;

    public GroupController(GroupService groupService,
                           GroupRepository groupRepository) {
        this.groupService = groupService;
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<List<UserDto>> getMembersOfGroup(@PathVariable Long groupId) {
        List<UserDto> users = groupService.getMembersOfGroup(groupId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}/users/{userId}")
    public ResponseEntity<Void> removeUserFromGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        groupService.removeUserFromGroup(groupId, userId);
        return ResponseEntity.noContent().build();
    }

}
