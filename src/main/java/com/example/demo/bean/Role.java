package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @author by HZL
 * @date 2019/12/20 10:53
 * @description
 */

@SuppressWarnings("ALL")
@Entity
@Table(name = "tb_role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "authority")
    private String authority;

}
