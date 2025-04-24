package com.secapp.config;

import com.secapp.repo.UserEntity;
import com.secapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity=userService.findByUsername(username);
        System.out.println("--------------------------");
        System.out.println(userEntity);

        if(userEntity==null){
            throw  new UsernameNotFoundException("user is not valid");
        }
        //i have a user that is not understood by spring sec--> he understand a user ie is impl UserDetails
        return new SecUser(userEntity);
    }
}
