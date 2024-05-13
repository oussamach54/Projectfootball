package com.example.tournoifootball.security.repositories;

import com.example.tournoifootball.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoleRepository extends JpaRepository<Role, String> {

    Role findByName(String newRole);
}
