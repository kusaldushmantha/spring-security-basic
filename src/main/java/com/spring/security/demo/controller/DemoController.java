package com.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Purpose: Demo Controller
 * Created By: Kusal Kankanamge
 * Created On: 01-May-2020
 */
@Controller
public class DemoController
{
    @GetMapping( "/" )
    public String showHome()
    {
        return "landing-page";
    }

    @GetMapping( "/home" )
    public String showLogin()
    {
        return "home-page";
    }

    @GetMapping( "/sign-up" )
    public String showSignUp()
    {
        return "signup-page";
    }

    @GetMapping( "/leaders" )
    public String showLeadersPage()
    {
        return "leaders-page";
    }

    @GetMapping( "/systems" )
    public String showSystemsPage()
    {
        return "systems-page";
    }
}
