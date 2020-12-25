package com.qiu.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter begin");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        //todo 一定要调用doFilter,向下传递
        System.out.println("请求执行前");
        chain.doFilter(request, response);
        System.out.println("请求执行后");

    }

    @Override
    public void destroy() {
        System.out.println("filter destroy");

    }
}
