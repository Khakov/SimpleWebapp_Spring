package ru.kpfu.itis.khakov.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.kpfu.itis.khakov.entity.User;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestCustomUserDetailService {
    private  static CustomUserDetailService userDetailsService;
    private static User user;

    @BeforeClass
    public static void init(){
        userDetailsService = new CustomUserDetailService();
        user = new User();
        user.setUsername("login");
        userDetailsService.userService= mock(UserService.class);
        when(userDetailsService.userService.getByUsername(anyString())).thenReturn(user);
    }

    @Test
    public void GetUserShouldBeWorkCorrect(){
        Assert.assertEquals(user, userDetailsService.loadUserByUsername("user"));
    }

}
