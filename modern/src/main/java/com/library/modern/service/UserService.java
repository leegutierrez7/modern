package com.library.modern.service;

import com.library.modern.models.Role;
import com.library.modern.models.User;
import com.library.modern.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    public User createUser(User user, String roleName){
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleService.findByName(roleName);
        if (userRole == null){
            userRole = roleService.saveRole(new Role(roleName));
        }

        user.getRoles().add(userRole);
        return userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
