package com.yunuskaya.banka.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "name")
    private String name;
    @Column(name= "surname")
    private String surname;
    @Column(name= "username")
    private String username;
    @Column(name= "password")
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    @Column(name= "email")
    private String email;
    @Column(name= "phone")
    private String phone;
    @Column(name= "address")
    private String address;
    @Column(name= "job")
    private String job;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List <Account> accounts;
}