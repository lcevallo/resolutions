package com.lcevallo.springsecurity.resolutions.service;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.lcevallo.springsecurity.resolutions.models.User;
import com.lcevallo.springsecurity.resolutions.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserRepositoryUserDetailService(UserRepository users) {
        this.userRepository = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        return this.userRepository.findByUsername(username)
        .map(BridgeUser::new)
        .orElseThrow(() ->new UsernameNotFoundException(username));
                
    }

    private static class BridgeUser extends User implements UserDetails {

        public BridgeUser(User user) {
            super(user);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return super.getUserAuthorities().stream()
            .map(userAuthority -> new SimpleGrantedAuthority(userAuthority.getAuthority()))
            .collect(Collectors.toList());
        }

        @Override
        public boolean isAccountNonExpired() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public boolean isEnabled() {
            // TODO Auto-generated method stub
            return super.getEnabled();
        }
    }

}