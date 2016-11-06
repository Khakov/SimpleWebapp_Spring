package ru.kpfu.itis.khakov.entity;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestUser {
    private static User user;

    @BeforeClass
    public static void init() {
        user = mock(User.class);
        when(user.getId()).thenReturn(1L);
        when((user.getUsername())).thenReturn("login");
        when(user.getPassword()).thenReturn("pass");
        when(user.getRole()).thenReturn("USER");

    }

    @Test
    public void GetUsernameShouldBeWorkCorrect() {
        User testUser = new User("login", "pass");
        Assert.assertEquals(user.getUsername(), testUser.getUsername());
    }

    @Test
    public void GetPasswordShouldBeWorkCorrect() {
        User testUser = new User("login", "pass");
        Assert.assertEquals(user.getPassword(), testUser.getPassword());
    }

    @Test
    public void GetRoleShouldBeWorkCorrect() {
        User testUser = new User("login", "pass");
        Assert.assertEquals(user.getRole(), testUser.getRole());
    }

    @Test
    public void EqualsShouldReturnTrue() {
        User testUser = new User("login", "pass");
        User testUser2 = new User("login", "pass");
        Assert.assertEquals(testUser, testUser2);
    }

    @Test
    public void EqualsShouldReturnFalse() {
        User testUser = new User("login", "pass");
        User testUser2 = new User("login", "password");
        Assert.assertNotEquals(testUser, testUser2);
    }

    @Test
    public void toStringShouldBeWorkCorrect() {
        User testUser = new User("login", "pass");
        Assert.assertEquals(testUser.toString(), "User{id=null, username='login', password='pass', role='USER'}");
    }

    @Test
    public void SetRoleShouldBeWorkCorrect() {
        User testUser = new User();
        testUser.setRole("ADMIN");
        Assert.assertEquals(testUser.getRole(), "ADMIN");
    }

    @Test
    public void SetUsernameShouldBeWorkCorrect() {
        User testUser = new User();
        testUser.setUsername("user");
        Assert.assertEquals(testUser.getUsername(), "user");
    }

    @Test
    public void SetPasswordShouldBeWorkCorrect() {
        User testUser = new User();
        testUser.setPassword("123456");
        Assert.assertEquals(testUser.getPassword(), "123456");
    }
}
