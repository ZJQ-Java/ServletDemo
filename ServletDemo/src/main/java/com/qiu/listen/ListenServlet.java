package com.qiu.listen;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Optional;

public class ListenServlet implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext session = se.getSession().getServletContext();
        Optional<Object> onlineCount = Optional.ofNullable(session.getAttribute("onlineCount"));
        if (onlineCount.isPresent()) {
            int o = (int) onlineCount.get();
            session.setAttribute("onlineCount", ++o);
        } else {
            session.setAttribute("onlineCount", 1);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Optional<Object> onlineCount = Optional.ofNullable(session.getAttribute("onlineCount"));
        if (onlineCount.isPresent()) {
            int o = (int) onlineCount.get();
            session.setAttribute("onlineCount", --o);
        } else {
            session.setAttribute("onlineCount", 0);
        }
    }
}
