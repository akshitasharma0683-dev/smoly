package akshitasharma0683_dev.smoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import akshitasharma0683_dev.smoly.Entity.User;
import akshitasharma0683_dev.smoly.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<User> register(
            @RequestBody User user
    ) {

        return ResponseEntity.ok(
                authService.register(user)
        );
    }

@PostMapping("/login")
public ResponseEntity<String> login(
        @RequestBody User user,
        HttpServletResponse response
) {

    String token =
            authService.login(
                    user.getEmail(),
                    user.getPassword()
            );

    Cookie cookie = new Cookie(
            "SMOLY_TOKEN",
            token
    );

    cookie.setHttpOnly(true);
    cookie.setPath("/");
    cookie.setMaxAge(60 * 60 * 24);

    response.addCookie(cookie);

    return ResponseEntity.ok("Login successful");
}

@PostMapping("/logout")
public ResponseEntity<String> logout(
        HttpServletResponse response
) {

    Cookie cookie = new Cookie(
            "SMOLY_TOKEN",
            null
    );

    cookie.setHttpOnly(true);
    cookie.setPath("/");
    cookie.setMaxAge(0);

    response.addCookie(cookie);

    return ResponseEntity.ok("Logged out");
}
}