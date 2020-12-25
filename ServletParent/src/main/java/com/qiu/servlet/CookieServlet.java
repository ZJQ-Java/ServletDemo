package com.qiu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Random;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo 设置encoding ，contentType
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        Cookie[] cookies = req.getCookies();
        PrintWriter writer = resp.getWriter();

        if (cookies == null || cookies.length == 0) {
            writer.println("<h1> cookie is null <h1>");
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    String decode = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    writer.println("userName -> value= " + decode);
//                    cookie.setValue(URLEncoder.encode("张金秋"+getRandom(), "UTF-8") );
//                    resp.addCookie(cookie);

                    return;
                }
            }
        }
        Cookie cookie = new Cookie("userName", URLEncoder.encode("张金秋", "UTF-8") );
//        cookie.setMaxAge(1);
        resp.addCookie(cookie);
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(100);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
