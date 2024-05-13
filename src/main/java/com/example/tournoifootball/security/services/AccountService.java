package com.example.tournoifootball.security.services;

import com.example.tournoifootball.security.entities.Role;
import com.example.tournoifootball.security.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    User createUser(String username, String password, String email, String confirmPassword);
    Role createRole(String newRole);
    void addRoleToUser(String username, String newRole);
    void removeRoleToUser(String username, String newRole);
    User loadUserByUsername(String username);
}
