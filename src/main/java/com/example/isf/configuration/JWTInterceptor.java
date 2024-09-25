package com.example.isf.configuration;

import com.example.isf.model.Utilisateur;
import com.example.isf.service.UtilisateurService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class JWTInterceptor extends OncePerRequestFilter {

    @Autowired
    private JWTManager jwt;
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = getJWTFromRequest(request);
        if (StringUtils.hasText(token)) {
            try {
                jwt.validateToken(token);
                String email = jwt.getClaim(token, "email");
                String pwd = jwt.getClaim(token, "password");
                Utilisateur users = this.utilisateurService.login(email, pwd);
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(users, null);
                SecurityContextHolder.getContext().setAuthentication(authToken);

            } catch (AuthenticationCredentialsNotFoundException e) {
                logger.error("AuthenticationCredentialsNotFoundException: " + e.getMessage());
                HashMap<String, String> result = new HashMap<>();
                result.put("error", e.getMessage());

                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(new ObjectMapper().writeValueAsString(result));
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        filterChain.doFilter(request, response);
    }


    public static String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
