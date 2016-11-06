package ru.kpfu.itis.khakov.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.repository.UserRepository;


import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class TestUserService {
    private static UserService userService;
    private static User user;


    @BeforeClass
    public static void init() {
        userService = new UserService();
        userService.userRepository = mock(UserRepository.class);
        user = new User();
        user.setUsername("login@login.com");
        user.setId(1L);
        user.setRole("user");
        user.setPassword("123456");
        when(userService.userRepository.findById(anyLong())).thenReturn(user);
        when(userService.userRepository.saveAndFlush(any(User.class))).thenReturn(user);
        when(userService.userRepository.saveAndFlush(any(User.class))).thenReturn(user);
    }

    @Test
    public void getByIdShouldReturnCorrectUser() {
        Assert.assertEquals(userService.getById(1L), user);
    }

    @Test
    public void addShouldAddUser() {
        User user1 = new User();
        user1.setUsername("login@login.com");
        user1.setId(1L);
        user1.setRole("user");
        user1.setPassword("123456");
        Assert.assertEquals(userService.add(user1), user);
    }
}
