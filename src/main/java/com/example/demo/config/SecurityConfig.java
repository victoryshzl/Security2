package com.example.demo.config;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author by HZL
 * @date 2019/12/20 11:28
 * @description
 */

@SuppressWarnings("ALL")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth)throws Exception{
       auth.authenticationProvider(authenticationProvider);
    }

    /**定义安全策略*/
    @Override
    protected void configure(HttpSecurity security) throws Exception{
        /**配置安全策略*/
        security.authorizeRequests()
                /**定义/springboot请求不需要验证*/
                .antMatchers("/springboot").permitAll()
                .antMatchers("/hello/**").hasRole("DBM")
                /**其余请求都需要验证*/
                .anyRequest().authenticated()
                .and()
                /**定义logout不需要验证*/
                .logout().permitAll()
                .and()
                /**使用form表单登录*/
                .formLogin();
    }
}
