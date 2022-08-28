package com.jwtSample.roleservice.model;

import lombok.*;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "role_auth")
public class Role{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
