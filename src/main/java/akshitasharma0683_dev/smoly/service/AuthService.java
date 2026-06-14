package akshitasharma0683_dev.smoly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import akshitasharma0683_dev.smoly.Entity.User;
import akshitasharma0683_dev.smoly.config.JwtService;
import akshitasharma0683_dev.smoly.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {

        if (userRepository.findByEmail(
                user.getEmail()
        ).isPresent()) {

            throw new RuntimeException(
                    "Email already exists"
            );
        }

        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()
                )
        );

        user.setRole("USER");

        return userRepository.save(user);
    }

    public String login(
        String email,
        String password
) {

    User user =
            userRepository
                    .findByEmail(email)
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "User not found"
                            ));

    if (!passwordEncoder.matches(
            password,
            user.getPassword()
    )) {

        throw new RuntimeException(
                "Invalid password"
        );
    }

    return jwtService.generateToken(
            user.getEmail()
    );
}
}

