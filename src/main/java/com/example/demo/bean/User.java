package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author by HZL
 * @date 2019/12/20 10:53
 * @description
 */

@SuppressWarnings("ALL")
@Entity
@Table(name = "tb_users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String loginName;
    private String username;
    private String password;

    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

}
