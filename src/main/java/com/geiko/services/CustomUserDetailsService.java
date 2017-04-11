package com.geiko.services;

import com.geiko.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Андрей on 11.04.2017.
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        com.geiko.models.User user = userService.findByName(name);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, authorities);
    }

    private UserDetails buildUserForAuthentication(com.geiko.models.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
        List<GrantedAuthority> result = new ArrayList<>();
        for (Role userRole : roles) {
            result.add(new SimpleGrantedAuthority(userRole.getName()));
        }
        return result;
    }
}
