package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by HZL
 * @date 2019/12/20 11:37
 * @description
 */

@RestController
public class SecurityController {
    @RequestMapping("/springboot")
    public String security(){
        return "hello world no security";
    }

    @PreAuthorize("hasRole('ROLE_DBM')")
    @RequestMapping("/")
    public String authorize(Authentication authentication){
        return "must security " + authentication.getName();
    }

    @RequestMapping("/hello/springboot")
    public String hello(Authentication authentication){
        return "hello world must security " + authentication.getName();
    }

}
