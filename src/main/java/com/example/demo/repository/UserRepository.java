package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author by HZL
 * @date 2019/12/20 11:18
 * @description
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByLoginName(String loginName);
}
