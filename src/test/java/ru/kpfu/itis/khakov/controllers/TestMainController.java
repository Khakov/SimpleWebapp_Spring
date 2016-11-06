package ru.kpfu.itis.khakov.controllers;

import org.junit.Assert;
import org.junit.Test;

public class TestMainController {
    @Test
    public void MainPageShouldRedirectToWelcomePage(){
        MainController controller = new MainController();
        Assert.assertEquals(controller.getMainPage(), "redirect:/welcome");
    }
}
