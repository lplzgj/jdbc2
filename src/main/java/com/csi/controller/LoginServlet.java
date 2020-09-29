package com.csi.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);

        String token = req.getParameter("token");
        String word = (String) req.getSession().getAttribute("word");
        if (token!=null&&word!=null&&token.equals(word)){
            System.out.println(req.getParameter("account")+"---"+req.getParameter("password"));
            req.getSession().removeAttribute("word");
            System.out.println(req.getSession().getAttribute("word"));
            req.getRequestDispatcher("demo2.jsp").forward(req,resp);
        }else {
            req.setAttribute("info","对不起，您重复提交数据了");
            req.getRequestDispatcher("message.jsp").forward(req,resp);
        }
    }
}
