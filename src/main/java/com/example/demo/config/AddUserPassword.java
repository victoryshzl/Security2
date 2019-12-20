package com.example.demo.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author by HZL
 * @date 2019/12/20 11:39
 * @description
 */
public class AddUserPassword {
    public static void main(String[] args){
        String p=new BCryptPasswordEncoder().encode("admin");
        System.out.println(p);
    }
}
