package ru.kpfu.itis.khakov.forms;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestRegistrationForm {
    private static RegistrationForm form;

    @BeforeClass
    public static void init() {
        form = mock(RegistrationForm.class);
        when((form.getUsername())).thenReturn("login");
        when(form.getPassword()).thenReturn("pass");
        when(form.getConfirmPassword()).thenReturn("pass");

    }

    @Test
    public void GetUsernameShouldBeWorkCorrect() {
        RegistrationForm form1 = new RegistrationForm("login", "pass", "pass");
        Assert.assertEquals(form.getUsername(), form1.getUsername());
    }

    @Test
    public void GetPasswordShouldBeWorkCorrect() {
        RegistrationForm form1 = new RegistrationForm("login", "pass", "pass");
        Assert.assertEquals(form.getPassword(), form1.getPassword());
    }

    @Test
    public void GetConfirmPasswordShouldBeWorkCorrect() {
        RegistrationForm form1 = new RegistrationForm("login", "pass", "pass");
        Assert.assertEquals(form.getConfirmPassword(), form1.getConfirmPassword());
    }

    @Test
    public void EqualsShouldReturnFalse() {
        RegistrationForm form1 = new RegistrationForm("login", "pass", "pass");
        RegistrationForm form2 = new RegistrationForm("login1", "pass", "pass");
        Assert.assertNotEquals(form1, form2);
    }

    @Test
    public void toStringShouldBeWorkCorrect() {
        RegistrationForm form1 = new RegistrationForm("login", "pass", "pass");
        Assert.assertEquals(form1.toString(),
                "RegistrationFormBean{, username='login', password='pass', confirmPassword='pass'}");
    }

    @Test
    public void SetConfirmPasswordShouldBeWorkCorrect() {
        RegistrationForm form1 = new RegistrationForm();
        form1.setConfirmPassword("pass");
        Assert.assertEquals(form1.getConfirmPassword(), "pass");
    }

    @Test
    public void SetUsernameShouldBeWorkCorrect() {
        RegistrationForm form1 = new RegistrationForm();
        form1.setUsername("login");
        Assert.assertEquals(form1.getUsername(), "login");
    }

    @Test
    public void SetPasswordShouldBeWorkCorrect() {
        RegistrationForm form1 = new RegistrationForm();
        form1.setPassword("pass");
        Assert.assertEquals(form1.getPassword(), "pass");
    }
}
