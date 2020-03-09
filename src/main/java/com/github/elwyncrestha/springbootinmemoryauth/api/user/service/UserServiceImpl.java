package com.github.elwyncrestha.springbootinmemoryauth.api.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.elwyncrestha.springbootinmemoryauth.api.user.entity.User;
import com.github.elwyncrestha.springbootinmemoryauth.api.user.repository.UserRepository;

/**
 * @author Elvin Shrestha on 3/9/2020
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(
        UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    @Override
    public User getAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            User user = (User) authentication.getPrincipal();
            user = this.findByUsername(user.getUsername());
            return user;
        } else {
            throw new UsernameNotFoundException(
                "User is not authenticated; Found " + " of type " + authentication.getPrincipal()
                    .getClass() + "; Expected type User");
        }
    }
}
