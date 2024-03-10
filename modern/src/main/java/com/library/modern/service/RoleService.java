package com.library.modern.service;

import com.library.modern.models.Role;
import com.library.modern.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

}
