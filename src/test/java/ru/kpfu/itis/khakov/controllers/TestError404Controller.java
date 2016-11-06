package ru.kpfu.itis.khakov.controllers;

import org.junit.Assert;
import org.junit.Test;

public class TestError404Controller {

    @Test
    public void ErrorPageShouldRedirectToWelcomePage(){
        Error404Controller error404Controller = new Error404Controller();
        Assert.assertEquals(error404Controller.getErrorPage(), "redirect:/welcome");
    }
}
