package com.sumanth.employeeManagement.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController {

    @RequestMapping("/home")
    public @ResponseBody
    String dashBoard(Authentication authentication) {
        String welcomeMsg = "";
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            welcomeMsg += "<h1>Welcome " + authentication.getName() + ", You have logged in as " + role+"</h1>";
        }
        return welcomeMsg;
    }
}
