package com.qiu.servlet;

import com.qiu.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionSetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        if (session.isNew()) {
            resp.getWriter().println("session is new");
        }else{
            resp.getWriter().println("session is old id=" +session.getId() );
        }
        Person person = (Person)session.getAttribute("person");
        if (person == null) {
            resp.getWriter().println("first set person");
            session.setAttribute("person", new Person("张金秋", 1));
            //失效
            session.invalidate();
        } else {
            resp.getWriter().println("already exist person:" + person.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
