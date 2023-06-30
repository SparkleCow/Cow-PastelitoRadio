package com.radio.radioServidor.Security.Jwt;

import com.radio.radioServidor.Security.ServiceSecurity.UserDetailsServiceImp;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.List;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    public UserDetailsServiceImp userDetailsServiceImp;
    @Autowired
    public JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getJwtFromRequest(request);
        if(StringUtils.hasText(token) && jwtUtils.validateToken(token)){
            String username = jwtUtils.getUsernameFromToken(token);
            UserDetails user = userDetailsServiceImp.loadUserByUsername(username);
            List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
            if(roles.contains("USER") || roles.contains("ADMIN")){
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user,
                        null, user.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }

    //Obtener el token que viene en el header de la petición
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        if(StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")){
            return bearer.substring(7, bearer.length());
        }
        return null;
    }
}
