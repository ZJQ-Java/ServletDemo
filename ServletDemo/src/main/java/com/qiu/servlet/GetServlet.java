package com.qiu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Properties;

public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String value = (String) servletContext.getAttribute("userName");
        value = Optional.ofNullable(value).orElse(servletContext.getInitParameter("url"));
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        InputStream resourceAsStream     = servletContext.getClassLoader().getResourceAsStream("prop.properties");
        Properties p = new Properties();
        p.load(resourceAsStream);
        String property = p.getProperty("servletValue");
        out.println("<h1>" + value + "<h1>");
        out.println("<h1>" + property + "<h1>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
