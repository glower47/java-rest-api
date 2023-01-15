package com.example.andreitrache.service.implementation;

import com.example.andreitrache.Constants;
import com.example.andreitrache.dto.UserDto;
import com.example.andreitrache.exception.UserException;
import com.example.andreitrache.model.User;
import com.example.andreitrache.repository.UserRepository;
import com.example.andreitrache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if( user.isEmpty() ) {
            throw new UserException(Constants.NO_USER_FOUND);
        }
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<UserDto> getAllUsers() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        List<User> users = userRepository.findAll(sort);
        return users.stream().map(UserDto::fromUser).collect(Collectors.toList());
    }

    @Override
    public User updateUser(Long id, UserDto user) {
        User existingUser = getUser(id);
        // update the existing user with the new values
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setProfilePicture(user.getProfilePicture());
        existingUser.setHeadline(user.getHeadline());
        existingUser.setSummary(user.getSummary());
        // save the updated user
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(Constants.NO_USER_FOUND));

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
