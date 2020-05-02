package com.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Purpose: Login Controller
 * Created By: Kusal Kankanamge
 * Created On: 01-May-2020
 */
@Controller
public class LoginController
{
    @GetMapping( "/showMyLoginPage" )
    public String showMyLoginPage()
    {
        return "fancy-login";
    }

    @GetMapping( "/myFirstPage" )
    public String showMyFirstPage()
    {
        return "first-page";
    }

    @GetMapping( "/access-denied" )
    public String showAccessDeniedPage()
    {
        return "access-denied-page";
    }
}
