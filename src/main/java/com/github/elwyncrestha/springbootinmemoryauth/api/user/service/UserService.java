package com.github.elwyncrestha.springbootinmemoryauth.api.user.service;

import com.github.elwyncrestha.springbootinmemoryauth.api.user.entity.User;

/**
 * @author Elvin Shrestha on 3/9/2020
 */
public interface UserService {

    User findByUsername(String username);

    User getAuthenticated();
}
