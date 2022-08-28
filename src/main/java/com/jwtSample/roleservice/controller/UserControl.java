package com.jwtSample.roleservice.controller;

import com.jwtSample.roleservice.model.Role;
import com.jwtSample.roleservice.model.User;
import com.jwtSample.roleservice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/v2")
@RequiredArgsConstructor
public class UserControl {
    @Autowired
    private final UserService userService;

    @GetMapping(name = "/users")
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "action=save-user")
    //@PostMapping(name = "/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "action=save-role")
    //@PostMapping(name = "/saveRole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        return new ResponseEntity<>(userService.saveRole(role),HttpStatus.OK);
    }

    @PostMapping(name = "addRoleToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleForm form) {
        userService.addRoleToUser(form.getUsername(),form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleForm {
    private String username;
    private String roleName;
}