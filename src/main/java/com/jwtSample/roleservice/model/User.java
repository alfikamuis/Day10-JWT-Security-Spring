package com.jwtSample.roleservice.model;

import lombok.*;

import com.jwtSample.roleservice.model.Role;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "user_auth")
public class User{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();
}
