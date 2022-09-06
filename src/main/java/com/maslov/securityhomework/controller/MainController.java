package com.maslov.securityhomework.controller;

import com.maslov.securityhomework.model.UserDO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping
    public String main(Model model, UserDO user) {
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("books", null);

        model.addAttribute("frontendData", data);

        return "index";
    }
}
