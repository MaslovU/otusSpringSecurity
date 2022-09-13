package com.maslov.securityhomework.controller;

import com.maslov.securityhomework.domain.Role;
import com.maslov.securityhomework.domain.MyUser;
import com.maslov.securityhomework.model.UserDo;
import com.maslov.securityhomework.service.data.provider.UserDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

import static java.util.Objects.nonNull;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class RegistrationController {
    private final UserDataProvider userDataProvider;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserDo user, Model model) {
        MyUser userFromDb = userDataProvider.findByName(user.getName());

        if (nonNull(userFromDb)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userDataProvider.createUser(user);

        return "redirect:/login";
    }
}
