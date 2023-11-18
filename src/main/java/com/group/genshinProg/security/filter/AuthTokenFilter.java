package com.group.genshinProg.security.filter;

import com.group.genshinProg.security.util.JwtTokenUtil;
import com.group.genshinProg.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.StringUtils.hasText;

public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = getTokenFromRequest(request);
        if (jwt != null) {
            if (jwtTokenUtil.validateJwtToken(jwt)) {
                //System.out.println("Зашли в if в фильтре");
                String username = jwtTokenUtil.getUserNameFromJwtToken(jwt);
                String usernameFromRequest = parseUsername(request);
                //System.out.println("Имя юзера из хедера  " + usernameFromRequest);

                if (!username.equals(usernameFromRequest)) throw new IOException();
                UserDetails userDetails = userService.loadUserByUsername(username);
                //System.out.println("Пароль " + userDetails.getPassword());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                        null);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else throw new IOException();
        }
        /*} catch (Exception e) {
            System.out.println("Пришел неверный токен");
        }*/

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }


    private String parseUsername(HttpServletRequest request) {
        String headerName = "Username";
        String headerAuth = request.getHeader(headerName);

        if (hasText(headerAuth)) return headerAuth;
        return null;
    }
}
