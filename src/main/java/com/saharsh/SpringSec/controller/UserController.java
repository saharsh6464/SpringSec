package com.saharsh.SpringSec.controller;
import com.saharsh.SpringSec.model.Users;
import com.saharsh.SpringSec.service.JwtService;
import com.saharsh.SpringSec.service.MyUserDetailsService;
import com.saharsh.SpringSec.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserSevice service;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private ApplicationContext context;

    @Autowired
    AuthenticationManager manager;

    @PostMapping("/register")
    public Users addUser(@RequestBody Users user){
        return service.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        Authentication authentication = manager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()){
            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(user.getUsername());
            return jwtService.generateToken(user.getUsername(),userDetails);
        }
        else{
            return "failed";
        }
    }

}
