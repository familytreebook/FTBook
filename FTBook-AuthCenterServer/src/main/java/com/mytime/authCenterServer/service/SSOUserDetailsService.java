package com.mytime.authCenterServer.service;

import com.mytime.authCenterServer.dto.Role;
import com.mytime.authCenterServer.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SSOUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String admin = "admin";
        //List<GrantedAuthority> roles = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
       List<Role> roleList = new ArrayList<>();
        roleList.add(new Role("USER"));
        if( admin.equals(s) ) {
            roleList.add(new Role("ADMIN"));
        }
        UserInfo u = new UserInfo( s, passwordEncoder.encode("123456"), roleList);
        u.setEnabled(true);
        return u;
    }
}