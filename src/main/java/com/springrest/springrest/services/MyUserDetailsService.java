package com.springrest.springrest.services;

import com.springrest.springrest.entities.User;
import com.springrest.springrest.entities.UserPrincipal;
import com.springrest.springrest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Requested Username: " + username);
        System.out.println("All Users: " + userRepo.findAll());
        User user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found!!");
            throw new UsernameNotFoundException("User Not Found!!");
        }

        return new UserPrincipal(user);
    }
}
