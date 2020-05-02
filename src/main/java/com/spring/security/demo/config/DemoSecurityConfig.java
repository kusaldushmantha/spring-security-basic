package com.spring.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

/**
 * Purpose: Security Configurations
 * Created By: Kusal Kankanamge
 * Created On: 01-May-2020
 */
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception
    {
/*      // Using in-memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
            .withUser( users.username( "john" ).password( "test123" ).roles( "EMPLOYEE" ) )
            .withUser( users.username( "mary" ).password( "test123" ).roles( "EMPLOYEE", "MANAGER" ) )
            .withUser( users.username( "susan" ).password( "test123" ).roles( "EMPLOYEE", "ADMIN" ) );*/

        // Using JDBC Authentication
        auth.jdbcAuthentication().dataSource( securityDataSource );

    }

    /**
     * This allows adding custom login-form and add HTTP URL security
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http.authorizeRequests()
            .antMatchers( "/" ).permitAll()
            .antMatchers( "/home" ).hasRole( "EMPLOYEE" )
            .antMatchers( "/leaders/**" ).hasRole( "MANAGER" )
            .antMatchers( "/systems/**" ).hasRole( "ADMIN" )
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage( "/showMyLoginPage" )
            .loginProcessingUrl( "/authenticateTheUser" )
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl( "/" )
            .permitAll()
            .and()
            .exceptionHandling()
            .accessDeniedPage( "/access-denied" );
    }
}
