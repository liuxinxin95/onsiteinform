package com.cpy.onsiteinform.config;

import com.alibaba.fastjson.JSONObject;
import com.cpy.onsiteinform.common.SysUser;
import com.cpy.onsiteinform.common.UserContext;
import com.cpy.onsiteinform.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private static final List<String> IGNORE_PATH = Arrays.asList("/swagger", "/api-docs", "/webjars", "/doc", "/web/api/", "mng/api/login/");


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        String serverPath = request.getRequestURI();
        if (IGNORE_PATH.stream().anyMatch(path -> serverPath.toLowerCase().contains(path))) {
            chain.doFilter(request, response);
            return;
        }
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        JSONObject object = JSONObject.parseObject(authentication.getPrincipal().toString());
        object.getString("openId");
        object.getString("userName");
        object.getString("phone");
        object.getString("userId");

        SecurityContextHolder.getContext().setAuthentication(authentication);
        SysUser sysUser = new SysUser();
        sysUser.setUserName(object.getString("userName"));
        sysUser.setMobile(object.getString("mobile"));
        sysUser.setUserId(object.getLong("userId"));
        UserContext.<SysUser>getContext().setCurrentUser(sysUser);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.
            Claims claims = JwtUtil.validateToken(token);
            if (claims.getSubject() != null) {
                return new UsernamePasswordAuthenticationToken(claims.getSubject(), null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }

}