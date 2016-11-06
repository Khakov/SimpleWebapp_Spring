package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/")
public class MainController {
    @Autowired
    HttpServletRequest request;
    /**
     * При заходе на сайт делаем перенаправление на страницу приветствия
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getMainPage() {
        return "redirect:/welcome";
    }
}
