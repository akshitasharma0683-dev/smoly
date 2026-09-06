package akshitasharma0683_dev.smoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import akshitasharma0683_dev.smoly.service.DashboardService;
import org.springframework.web.bind.annotation.RequestParam;
import akshitasharma0683_dev.smoly.Entity.User;
import akshitasharma0683_dev.smoly.repository.UserRepository;
import org.springframework.security.core.Authentication;
@Controller
public class PageController {
    @Autowired
    private DashboardService dashboardService;

    @Autowired
private UserRepository userRepository;

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
public String certificate(
        @RequestParam(
                name = "template",
                required = false,
                defaultValue = "CLASSIC"
        ) String template,
        Model model) {

    model.addAttribute(
            "template",
            template.toUpperCase()
    );

    return "certificate";
}

    @GetMapping("/certificate/create")
public String createCertificate(
        @RequestParam(
                name = "template",
                required = false,
                defaultValue = "CLASSIC"
        ) String template,
        Authentication authentication,
        Model model) {

    model.addAttribute("template", template.toUpperCase());

    String email = authentication.getName();

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    model.addAttribute("user", user);

    return "certificate-create";
}

    @GetMapping("/shortener")
    public String shortener() {
        return "shortener";
    }
}