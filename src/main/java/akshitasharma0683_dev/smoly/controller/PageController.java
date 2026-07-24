package akshitasharma0683_dev.smoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/certificate")
    public String certificate() {
        return "certificate";
    }

    @GetMapping("/shortener")
    public String shortener() {
        return "shortener";
    }
}