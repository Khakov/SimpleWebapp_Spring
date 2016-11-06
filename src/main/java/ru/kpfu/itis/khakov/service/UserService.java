package ru.kpfu.itis.khakov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.UserRepository;

import java.util.List;

/**
 * Created by Rus on 26.04.2016.
 */
@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    @Transactional
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User getById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public User add(User user) {
        return userRepository.saveAndFlush(user);
    }
}
