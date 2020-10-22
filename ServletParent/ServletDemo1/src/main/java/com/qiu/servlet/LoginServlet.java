package com.qiu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.qiu.constants.ConstantServlet.USER_SESSION;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("----------get--------------");
//        ServletContext context = req.getSession().getServletContext();
//        String username = req.getParameter("username");
//        System.out.println();
//        if ("admin".equals(username)) {
//            context.setAttribute(USER_SESSION, username);
//            resp.sendRedirect("sys/success.jsp");
//        } else {
//            resp.sendRedirect("/sys/logError.jsp");
//        }
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------post-----------------");
        ServletContext context = req.getSession().getServletContext();
        String username = req.getParameter("username");
        if ("admin".equals(username)) {
            context.setAttribute(USER_SESSION, username);
            resp.sendRedirect("/sys/success.jsp");
        } else {
            resp.sendRedirect("/logError.jsp");
        }
    }
}
