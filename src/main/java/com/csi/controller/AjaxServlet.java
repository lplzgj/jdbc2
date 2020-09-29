package com.csi.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String info =req.getParameter("info");
        System.out.println("name="+name);
        System.out.println("password="+password);
        System.out.println("info="+info);
        PrintWriter out = resp.getWriter();
        out.write("654321");
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);

        String info =req.getParameter("info");
        System.out.println("info="+info);
        PrintWriter out = resp.getWriter();
        out.write("123456");
        out.flush();

    }
}
