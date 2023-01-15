package com.example.andreitrache.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupMember> groupMembers = new ArrayList<>();

    public Group() {
    }

    public Group(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GroupMember> getGroupMembers() {
        return groupMembers;
    }

    public void addGroupMember(GroupMember groupMember) {
        groupMembers.add(groupMember);
        groupMember.setGroup(this);
    }

    public void removeGroupMember(GroupMember groupMember) {
        groupMembers.remove(groupMember);
        groupMember.setGroup(null);
    }
}
