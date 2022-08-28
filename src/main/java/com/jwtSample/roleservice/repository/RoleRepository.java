package com.jwtSample.roleservice.repository;

import com.jwtSample.roleservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("select r from Role r where r.name = ?1 ")
    Role findByRole(String rolename);
}
