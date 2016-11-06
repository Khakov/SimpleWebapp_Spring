package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    HttpServletRequest request;
    /**
     * Отображаем страницу приветствия
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderWelcomePage(ModelMap model) {
        if (request.getRemoteUser() != null) {
            model.put("user", request.getUserPrincipal().getName());
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            String day = "ое утро";
            if (hour >= 10 && hour < 18)
                day = "ый день";
            else {
                if (hour >= 18 && hour < 22)
                    day = "ый вечер";
                else if (hour >= 22 || hour < 6)
                    day = "ой ночи";
            }
            model.put("time", day);
            return "welcome";
        } else
            return "redirect:/sign-in?error=auth";
    }
}
