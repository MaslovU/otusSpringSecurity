package com.maslov.securityhomework.service.impl;

import com.maslov.securityhomework.domain.MyUser;
import com.maslov.securityhomework.domain.Role;
import com.maslov.securityhomework.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDetailsRepo userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        MyUser user = userRepository.findByName(username);
        if (user == null) throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        }

        return new User(user.getName(), encoder.encode(user.getPassword()), grantedAuthorities);
    }
}
