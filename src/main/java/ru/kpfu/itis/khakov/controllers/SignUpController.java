package ru.kpfu.itis.khakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.khakov.entity.User;
import ru.kpfu.itis.khakov.forms.RegistrationForm;
import ru.kpfu.itis.khakov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Controller

public class SignUpController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;

    /**
     * Отображение страницы регистрации
     */
    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String renderRegistrationPage() {
        if (request.getRemoteUser() != null) {
            return "redirect:/welcome";
        }
        request.setAttribute("regForm", new RegistrationForm());
        return "registration";
    }

    /**
     * Обработка формы Регистрации
     */
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String registrationForm(@Valid @ModelAttribute("regForm") RegistrationForm regForm,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (userService.getByUsername(regForm.getUsername().trim().toLowerCase()) != null) {
            model.addAttribute("error", "Такой пользователь уже существует");
            return "registration";
        } else {
            if (!regForm.getPassword().equals(regForm.getConfirmPassword())) {
                model.addAttribute("error", "пароли не совпадают!");
                return "registration";
            }
        }
        User user = new User(regForm.getUsername(), md5Decoder(regForm.getPassword()));
        userService.add(user);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(),
                user.getPassword(), user.getAuthorities()));
        return "redirect:/";
    }

    /**
     * MD5 хэширование пароля
     */
    private String md5Decoder(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.update(password.getBytes(), 0, password.length());
        String pass = new BigInteger(1, messageDigest.digest()).toString(16);
        if (pass.length() < 32) {
            pass = "0" + pass;
        }
        return pass;
    }
}