package com.revature.flashpoints.services;

import org.springframework.stereotype.Service;

import com.revature.flashpoints.dtos.requests.NewRoleRequest;
import com.revature.flashpoints.entities.Role;
import com.revature.flashpoints.repositories.RoleRepository;
import com.revature.flashpoints.utils.custom_exceptions.RoleNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    
    
    public Role saveRole(NewRoleRequest req) {
        Role newRole = new Role(req.getName());
        return roleRepository.save(newRole);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name)
            .orElseThrow(() -> new RoleNotFoundException("Role " + name + " not found"));
    }

    public boolean isUniqueRole(String name) {
        return roleRepository.findByName(name).isEmpty();
    }
}
