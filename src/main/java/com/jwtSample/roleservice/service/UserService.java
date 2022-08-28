package com.jwtSample.roleservice.service;

import com.jwtSample.roleservice.model.Role;
import com.jwtSample.roleservice.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    User getUser(String username);
    List<User>getUsers();

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);
}
