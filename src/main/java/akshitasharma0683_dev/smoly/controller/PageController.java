package akshitasharma0683_dev.smoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import akshitasharma0683_dev.smoly.service.DashboardService;

@Controller
public class PageController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute(
                "stats",
                dashboardService.getDashboardStats()
        );

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