package com.qiu.servlet;

import com.qiu.constant.Constants;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getSession().getServletContext();
        servletContext.removeAttribute(Constants.USER_SESSION);
        System.out.println("LogoutServlet remove" + servletContext.getAttribute(Constants.USER_SESSION));
        resp.sendRedirect("/login.jsp");
    }
}
