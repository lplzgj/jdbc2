package com.csi.controller;

import com.csi.domain.Dept;
import com.csi.service.DeptService;
import com.csi.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "DeptServlet",urlPatterns = "/dept")
public class DeptServlet extends HttpServlet {
    private DeptService ds;

    public DeptServlet() {
        this.ds = new DeptServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);

        //获取op
        String op = req.getParameter("op");
        //判断
        if ("addDept".equals(op)) {
            this.addDept(req, resp);
        } else if ("findAll".equals(op)) {
            this.findAll(req, resp);
        } else if ("remove".equals(op)) {
            this.remove(req,resp);
        } else if ("findById".equals(op)) {
            this.findById(req,resp);
        }else if ("update".equals(op)){
            this.update(req,resp);
        }else if ("ajax".equals(op)){
            this.ajax(req,resp);
        }
    }

    private void ajax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String deptno = req.getParameter("deptno");
        PrintWriter out = resp.getWriter();
        if (deptno!=null){
            Dept d = this.ds.findById(Integer.parseInt(deptno));
            out.write(d!=null?"1":"0");
            out.flush();
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        String dname = req.getParameter("dname");
        String loc = req.getParameter("loc");
        //调用业务层对象执行添加操作
        Dept dept = new Dept(deptno,dname,loc);
        String info = ds.update(dept);
        //设置请求属性
        req.setAttribute("info",info);
        //转发
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        Dept dept = ds.findById(deptno);
        req.setAttribute("dept",dept);
        req.getRequestDispatcher("findById.jsp").forward(req,resp);
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        String info=ds.delete(deptno);
        req.setAttribute("info",info);
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询所有部门
        List<Dept> all = this.ds.list();
        req.setAttribute("all", all);
        //请求
        req.getRequestDispatcher("showalldept.jsp").forward(req, resp);
    }

    protected void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno=req.getParameter("deptno");

        String dname=req.getParameter("dname");

        String loc=req.getParameter("loc");
        Dept dept1=new Dept(Integer.valueOf(deptno),dname,loc);
        //调用
        String info=ds.add(dept1);
        req.setAttribute("info",info);
        req.getRequestDispatcher("message.jsp").forward(req,resp);

    }
}