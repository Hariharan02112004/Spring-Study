package com.example.SpringSecurity1.Service;


import com.example.SpringSecurity1.Model.User;
import com.example.SpringSecurity1.Model.UserPrincipal;
import com.example.SpringSecurity1.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private userRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =repo.findByUsername(username);
        if(user ==null){
            throw new UsernameNotFoundException("404 User Not Found");
        }
        return new UserPrincipal(user);
    }
}
