package com.qiu.filter;

import com.qiu.constants.ConstantServlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        HttpServletResponse resp = (HttpServletResponse) response;
        String attribute = (String) session.getServletContext().getAttribute(ConstantServlet.USER_SESSION);
        if (attribute == null ) {
            resp.sendRedirect("/login.jsp");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
