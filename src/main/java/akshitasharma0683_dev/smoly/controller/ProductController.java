package akshitasharma0683_dev.smoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import akshitasharma0683_dev.smoly.Entity.User;
import akshitasharma0683_dev.smoly.repository.UserRepository;

@Controller
public class ProductController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/templates")
    public String templates(
            Authentication authentication,
            Model model) {

        addUserToModel(authentication, model);

        return "templates";
    }


    @GetMapping("/pricing")
    public String pricing(
            Authentication authentication,
            Model model) {

        addUserToModel(authentication, model);

        return "pricing";
    }


    @GetMapping("/premium-coming-soon")
    public String premiumComingSoon(
            Authentication authentication,
            Model model) {

        addUserToModel(authentication, model);

        return "premium-coming-soon";
    }


    private void addUserToModel(
            Authentication authentication,
            Model model) {

        String email = authentication.getName();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        model.addAttribute("user", user);
    }
}