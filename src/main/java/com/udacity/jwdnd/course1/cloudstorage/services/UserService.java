package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mappers.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final HashService hashService;

    public List<User> findAllUsers() { return userMapper.findAllUsers(); }

    public User findUserByUsername(String username) { return userMapper.findUserByUsername(username); }

    public void insert(User user) {
        if (findUserByUsername(user.getUsername()) != null) {throw new IllegalArgumentException("Username already exists");}
        String encodedSalt = hashService.generateEncodedSalt(); user.setSalt(encodedSalt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt); user.setPassword(hashedPassword);

        userMapper.insert(user); 
    }

    public void update(User user) { userMapper.update(user); }

    public void deleteUserById(int id) { userMapper.deleteUserById(id); }

    public void deleteUserByName(String username) { userMapper.deleteUserByName(username); }
}
