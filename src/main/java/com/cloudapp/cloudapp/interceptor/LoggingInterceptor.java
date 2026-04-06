
package com.cloudapp.cloudapp.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
    {
        logger.info("[ENTER] {} {}", request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) 
    {
        if (ex != null) 
        {
            logger.error("[EXCEPTION] {} - {}", ex.getClass().getSimpleName(), ex.getMessage());
        }
        logger.info("[EXIT] {} {}", request.getMethod(), request.getRequestURI());
    }
}