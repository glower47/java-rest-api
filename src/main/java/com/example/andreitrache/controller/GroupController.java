package com.example.andreitrache.controller;

import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.model.Group;
import com.example.andreitrache.repository.GroupRepository;
import com.example.andreitrache.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@Tag(name = "Group controller", description = "All group and group members related endpoints can be found here.")
public class GroupController {

    private final GroupService groupService;
    private final GroupRepository groupRepository;

    public GroupController(GroupService groupService,
                           GroupRepository groupRepository) {
        this.groupService = groupService;
        this.groupRepository = groupRepository;
    }

    @GetMapping
    @Operation(summary = "Get all groups", description = "This endpoint will return all the groups in the database.")
    public ResponseEntity<List<Group>> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    @Operation(summary = "Get all members for a specific group", description = "This endpoint will return all the members for a specific group.")
    public ResponseEntity<List<UserDto>> getMembersOfGroup(@PathVariable Long groupId) {
        List<UserDto> users = groupService.getMembersOfGroup(groupId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}/users/{userId}")
    @Operation(summary = "Remove a user from a group", description = "This endpoint will remove a user from a specific group")
    public ResponseEntity<Void> removeUserFromGroup(@PathVariable Long groupId, @PathVariable Long userId) {
        groupService.removeUserFromGroup(groupId, userId);
        return ResponseEntity.noContent().build();
    }

}
