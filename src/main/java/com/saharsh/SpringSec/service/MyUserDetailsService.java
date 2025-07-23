package com.saharsh.SpringSec.service;
import com.saharsh.SpringSec.model.UserPrincipal;
import com.saharsh.SpringSec.model.Users;
import com.saharsh.SpringSec.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user = repo.findByUsername(username);
       if(user == null){
           System.out.println("User Not found");
           throw new UsernameNotFoundException("User 404");
       }
       return new UserPrincipal(user);
    }

}
