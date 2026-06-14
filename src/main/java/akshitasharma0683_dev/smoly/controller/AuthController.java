package akshitasharma0683_dev.smoly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import akshitasharma0683_dev.smoly.Entity.User;
import akshitasharma0683_dev.smoly.service.AuthService;

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
        @RequestBody User user
) {

    String token =
            authService.login(
                    user.getEmail(),
                    user.getPassword()
            );

    return ResponseEntity.ok(token);
}

}