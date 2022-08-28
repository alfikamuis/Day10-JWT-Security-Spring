package com.jwtSample.roleservice.repository;

import com.jwtSample.roleservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select s from User s where s.username = ?1 ")
    User findByUserName(String username);
}
