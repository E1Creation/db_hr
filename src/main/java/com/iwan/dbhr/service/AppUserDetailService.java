package com.iwan.dbhr.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iwan.dbhr.model.AppUserDetail;
import com.iwan.dbhr.model.User;
import com.iwan.dbhr.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User doesnt exitst"));

        return new AppUserDetail(user);
    }

}
