package akshitasharma0683_dev.smoly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session ->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            )

            .authorizeHttpRequests(auth -> auth

                // =========================================
                // AUTHENTICATED PAGES
                // =========================================

                .requestMatchers(
                    "/dashboard"
                ).authenticated()


                // =========================================
                // PUBLIC PAGES
                // =========================================

                .requestMatchers(
                    "/",
                    "/login",
                    "/register",
                    "/certificate",
                    "/shortener",
                    "/templates",
                    "/pricing",
                    "/premium-coming-soon",
                    "/maintenance"
                ).permitAll()


                // =========================================
                // STATIC RESOURCES
                // =========================================

                .requestMatchers(
                    "/css/**",
                    "/js/**",
                    "/images/**",
                    "/icons/**"
                ).permitAll()


                // =========================================
                // AUTHENTICATION
                // =========================================

                .requestMatchers(
                    "/auth/register",
                    "/auth/login"
                ).permitAll()


                // =========================================
                // CERTIFICATE
                // =========================================

                .requestMatchers(
                    "/certificate/create",
                    "/certificate/pdf/**",
                    "/certificate/verify/**"
                ).permitAll()


                // =========================================
                // QR
                // =========================================

                .requestMatchers(
                    "/qr/**"
                ).permitAll()


                // =========================================
                // URL SHORTENER
                // =========================================

                .requestMatchers(
                    "/shorten",
                    "/{shortCode:[a-zA-Z0-9]+}"
                ).permitAll()


                // =========================================
                // EVERYTHING ELSE
                // =========================================

                .anyRequest().authenticated()
            )

            .addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {

        return config.getAuthenticationManager();
    }
}