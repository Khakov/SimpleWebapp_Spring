package ru.kpfu.itis.khakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/error404", method = RequestMethod.GET)
public class Error404Controller {
    /**
     * если страницы не существует перенаправляем на страницу приветствия
     */
    @RequestMapping
    public String getErrorPage() {
        return "redirect:/welcome";
    }
}
