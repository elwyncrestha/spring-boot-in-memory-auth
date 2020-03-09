package com.github.elwyncrestha.springbootinmemoryauth.core.config;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.github.elwyncrestha.springbootinmemoryauth.api.user.entity.User;
import com.github.elwyncrestha.springbootinmemoryauth.api.user.repository.UserRepository;
import com.github.elwyncrestha.springbootinmemoryauth.core.constant.AppConstant;
import com.github.elwyncrestha.springbootinmemoryauth.core.enums.Status;

/**
 * @author Elvin Shrestha on 3/9/2020
 */
@Component
public class StartUp {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public StartUp(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void populate() {
        createSuperAdmin();
    }

    private void createSuperAdmin() {
        final User admin = userRepository
            .findUserByUsername(AppConstant.DEFAULT_SUPER_ADMIN_USERNAME);
        if (admin == null) {
            final User user = new User();
            user.setName(AppConstant.DEFAULT_SUPER_ADMIN_NAME);
            user.setUsername(AppConstant.DEFAULT_SUPER_ADMIN_USERNAME);
            user.setPassword(passwordEncoder.encode(AppConstant.DEFAULT_SUPER_ADMIN_PASSWORD));
            user.setStatus(Status.ACTIVE);
            userRepository.save(user);
        }
    }

}
