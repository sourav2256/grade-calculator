package com.ltp.gradesubmission.security.filter;

import com.ltp.gradesubmission.exception.EntityNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//public class FilterOne implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println(((HttpServletRequest)servletRequest).getRequestURI());
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//}

public class ExceptionHandlerFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            filterChain.doFilter(request, response);
        } catch (EntityNotFoundException e) { //Feel free to create a separate function.
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Username doesn't exist");
            response.getWriter().flush();
        }
        catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST, "Fail");
        }
    }
}