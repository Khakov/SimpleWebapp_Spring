package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@Controller

public class SignInController {
    @Autowired
    HttpServletRequest request;
    /**
     * Отображение страницы авторизации
     */
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String renderLoginPage(ModelMap model, @RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {
        if (request.getRemoteUser() != null) {
            return "redirect:/welcome";
        }
        if (error != null) {
            if (error.equals("auth")) {
                model.put("error", "Необходимо ввести учетные данные");
            } else
                model.put("error", "Имя пользователя и пароль не подходят");
        }
        if (logout != null) {
            model.put("success", "Вы вышли из приложения");
        }
        return "login";
    }
}
