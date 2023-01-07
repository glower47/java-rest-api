package com.example.andreitrache.service;

import com.example.andreitrache.Exception.UserNotFoundException;
import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.model.User;
import com.example.andreitrache.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserDto> getAllUsers() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<User> users = userRepository.findAll(sort);
        return users.stream().map(UserDto::fromUser).collect(Collectors.toList());
    }
    public User updateUser(Long id, User user) {
        User existingUser = getUser(id);
        // update the existing user with the new values
        existingUser.setName(user.getName());
        existingUser.setProfilePicture(user.getProfilePicture());
        existingUser.setEmail(user.getEmail());
        // save the updated user
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteFirstConnections(id);
        userRepository.deleteSecondConnections(id);
        userRepository.deleteEducation(id);
        userRepository.deleteExperience(id);
        userRepository.deleteGroupMember(id);
        userRepository.deleteProfile(id);
        userRepository.deleteSkills(id);
        userRepository.deleteById(id);
    }

}
