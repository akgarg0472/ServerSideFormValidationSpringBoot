package com.akgarg.serversideformvalidationspringboot.controller;

import com.akgarg.serversideformvalidationspringboot.model.UserLoginInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class FormController {

    // handler method for main url("/") which redirects to the login page
    // because we don't have anything on home page for this project.
    @RequestMapping("/")
    public String main() {
        return "redirect:login";
    }

    // handler method for the login form display
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("userLoginInformation", new UserLoginInformation());
        return "form";
    }

    // handler method to process form
    @PostMapping("/submit-form")
    public String formSubmit(@Valid @ModelAttribute("userLoginInformation") UserLoginInformation userLoginInformation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "form";
        }

        System.out.println(userLoginInformation);
        return "login-success";
    }

    // handler method for successful login show
    @RequestMapping("login-success")
    public String loginSuccess() {
        return "login-success";
    }
}