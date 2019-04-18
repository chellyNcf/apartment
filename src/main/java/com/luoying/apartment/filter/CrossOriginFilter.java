package com.luoying.apartment.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * iframe跨域
 */
@WebFilter(urlPatterns = "/")
public class CrossOriginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        response.setHeader("X-Frame-Options", "ALLOW-FROM http://localhost:8080/apartment/html");
        filterChain.doFilter(request,response);
    }

}
