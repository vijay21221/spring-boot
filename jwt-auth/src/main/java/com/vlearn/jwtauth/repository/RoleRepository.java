package com.vlearn.jwtauth.repository;

import com.vlearn.jwtauth.model.ERole;
import com.vlearn.jwtauth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {

    public Role findByName(ERole name);

}
