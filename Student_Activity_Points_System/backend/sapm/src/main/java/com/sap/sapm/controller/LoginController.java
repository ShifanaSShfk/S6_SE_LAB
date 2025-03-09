package com.sap.sapm.controller;

import com.sap.sapm.model.User;
import com.sap.sapm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @SuppressWarnings("unlikely-arg-type")
    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            
            // Direct string comparison (without hashing)
            if (password.equals(user.getPassword())) {
                if ("STUDENT".equals(user.getRoles())) {
                    return "redirect:/student/dashboard";
                } else if ("FACULTY".equals(user.getRoles())) {
                    return "redirect:/faculty/dashboard";
                }
            }
        }

        model.addAttribute("error", "Invalid credentials");
        return "login";
    }
}
