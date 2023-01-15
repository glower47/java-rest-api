package com.example.andreitrache.service.implementation;

import com.example.andreitrache.repository.ConnectionRepository;
import com.example.andreitrache.repository.GroupRepository;
import com.example.andreitrache.service.GroupService;
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

}
