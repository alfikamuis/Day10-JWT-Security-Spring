package com.jwtSample.roleservice.service;


import com.jwtSample.roleservice.model.Role;
import com.jwtSample.roleservice.model.User;
import com.jwtSample.roleservice.repository.RoleRepository;
import com.jwtSample.roleservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional
@Slf4j //for log
public class UserServiceImp implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user == null){
            log.error("User not found!");
            throw new UsernameNotFoundException("User not found!");
        } else {
            log.info("User {} in database", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority((role.getName())));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
    @Override
    public User saveUser(User user) {
        log.info("add user");
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        log.info("get user by username");
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("get all user");
        return userRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        log.info("add role");
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("add role to user");
        User byUserName = userRepository.findByUserName(userName);
        Role byRole = roleRepository.findByRole(roleName);
        byUserName.getRoles().add(byRole);
    }


}
