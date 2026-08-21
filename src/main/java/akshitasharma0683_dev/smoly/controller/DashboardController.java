package akshitasharma0683_dev.smoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import akshitasharma0683_dev.smoly.Entity.User;
import akshitasharma0683_dev.smoly.repository.UserRepository;
import akshitasharma0683_dev.smoly.service.DashboardService;

@Controller
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public String dashboard(
            Authentication authentication,
            Model model) {

        String email = authentication.getName();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        model.addAttribute("user", user);

        model.addAttribute(
                "certificates",
                dashboardService.getUserCertificates(user)
        );

        model.addAttribute(
                "certificateCount",
                dashboardService.getCertificateCount(user)
        );

        return "dashboard";
    }
}