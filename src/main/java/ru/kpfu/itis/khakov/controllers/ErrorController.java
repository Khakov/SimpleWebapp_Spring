package ru.kpfu.itis.khakov.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class ErrorController {
    @RequestMapping
    public String getErrorPage() {
        return "error";
    }
}
