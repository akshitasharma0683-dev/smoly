package akshitasharma0683_dev.smoly.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

   @Override
protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
) throws ServletException, IOException {

    String token = null;

    // =========================================
    // CHECK AUTHORIZATION HEADER
    // =========================================

    String authHeader =
            request.getHeader("Authorization");

    if (authHeader != null &&
            authHeader.startsWith("Bearer ")) {

        token = authHeader.substring(7);
    }


    // =========================================
    // CHECK JWT COOKIE
    // =========================================

    if (token == null &&
            request.getCookies() != null) {

        for (Cookie cookie : request.getCookies()) {

            if ("SMOLY_TOKEN".equals(cookie.getName())) {

                token = cookie.getValue();
                break;
            }
        }
    }


    // =========================================
    // NO TOKEN
    // =========================================

    if (token == null) {

        filterChain.doFilter(request, response);
        return;
    }


    // =========================================
    // VALIDATE TOKEN
    // =========================================

    String email =
            jwtService.extractEmail(token);

    if (email != null &&
            SecurityContextHolder
                    .getContext()
                    .getAuthentication() == null) {

        UserDetails userDetails =
                userDetailsService
                        .loadUserByUsername(email);

        if (jwtService.isTokenValid(
                token,
                userDetails.getUsername()
        )) {

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            authToken.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request)
            );

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authToken);
        }
    }

    filterChain.doFilter(request, response);
}
}