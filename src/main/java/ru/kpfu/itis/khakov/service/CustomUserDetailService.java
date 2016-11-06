package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.User;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    public UserService userService;
    /**
     * Настраиваем провайдер авторизации пользователя
     */
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username.trim().toLowerCase());
        if (user == null) throw new UsernameNotFoundException("User with name " + username + " not found");
        return user;
    }
}

