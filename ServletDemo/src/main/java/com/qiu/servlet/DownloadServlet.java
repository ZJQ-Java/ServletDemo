package com.qiu.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String path = req.getServletContext().getRealPath("/dl.jpg");
        InputStream in = this.getServletContext().getClassLoader().getResourceAsStream("/dl.jpg");
//        System.out.println(path);
//        InputStream f = new FileInputStream(path);
        resp.setContentType("image/jpg");
        resp.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("ddd.jpg","UTF-8"));
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len=in.read(buffer))!=-1){
            //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
            outputStream.write(buffer, 0, len);
        }

        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
