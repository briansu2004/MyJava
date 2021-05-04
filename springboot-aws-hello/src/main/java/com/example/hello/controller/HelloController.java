package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HelloController {

    @GetMapping({ "/", "hello" })
    public String hello(Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        return "hello";
    }

}
