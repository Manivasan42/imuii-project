package com.example.SpringInterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class ParameterInterceptor implements HandlerInterceptor {

    public ParameterInterceptor() {
        System.out.println("ParameterInterceptor instantiated");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor is called"); // Debugging statement
        String value = request.getParameter("value");

        // Check for null
        if (value == null) {
            response.setStatus(HttpServletResponse.SC_FOUND); // Set status to 404 Not Found
            System.out.println("prehandle: Missing 'value' parameter");
            return false; // Stop further processing
        }
        HandlerInterceptor.super.preHandle(request,response,handler);
        return true; // Continue processing
    }
}