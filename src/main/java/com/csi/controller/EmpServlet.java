package com.csi.controller;

import com.csi.domain.Dept;
import com.csi.domain.Emp;
import com.csi.domain.Page;
import com.csi.service.DeptService;
import com.csi.service.EmpService;
import com.csi.service.impl.DeptServiceImpl;
import com.csi.service.impl.EmpServiceImpl;
import com.csi.util.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "EmpServlet",urlPatterns = "/emp")
public class EmpServlet extends HttpServlet {
    private DeptService ds;
    private EmpService es;

    public EmpServlet() {
        this.ds = new DeptServiceImpl();
        this.es = new EmpServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);

        //��ȡop
        String op = req.getParameter("op");
        //�ж�
        if ("addFind".equals(op)) {
            try {
                this.addFind(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("addEmp".equals(op)) {
            try {
                this.addEmp(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if ("findAll".equals(op)) {
            try {
                this.findAll(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else  if ("findById".equals(op)){
            try {
                this.findById(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else  if ("updateEmp".equals(op)){
            try {
                this.updateEmp(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else  if ("remove".equals(op)){
            try {
                this.remove(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //�����û����ݹ�����ֵ
        String empno = req.getParameter("empno");
        //����service����ɾ��
        String info = this.es.delEmpByEmpNo(Integer.valueOf(empno));
        //this.findAll(req,resp);��Ӧ�ض���
        resp.sendRedirect(this.getServletContext().getContextPath()+"/emp?op=findAll");
        /*//������������
        req.setAttribute("info",info);
        //����������תת��ҳ��
        req.getRequestDispatcher("message.jsp").forward(req,resp);*/
    }

    private void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //�����û����ݹ�����ֵ
        String empno = req.getParameter("empno");
        String ename = req.getParameter("ename");
        String job = req.getParameter("job");
        String mgr = req.getParameter("mgr");
        String hiredate = req.getParameter("hiredate");
        String sal = req.getParameter("sal");
        String comm = req.getParameter("comm");
        String deptno = req.getParameter("deptno");
        Dept d = new Dept();
        d.setDeptno(Integer.valueOf(deptno));
        //�����޸�Ա����Ϣ�ķ���
        String info = this.es.updateEmp(new Emp(
                Integer.valueOf(empno),
                ename,
                job,
                Integer.valueOf(mgr),
                DateFormat.stringToDate(hiredate),
                Double.valueOf(sal),
                Double.valueOf(comm),
                d
        ));
        //������������
        req.setAttribute("info",info);
        //ת��
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        //�����û����ݹ�����ֵ
        String empno = req.getParameter("empno");
        //����ҵ����ѯ������Ϣ
        Emp emp = this.es.findEmpByEmpNo(Integer.parseInt(empno));
        //��ѯ���в���
        List<Dept> deptAll = this.ds.list();
        //��ѯ�����쵼
        List<Emp> managerAll = this.es.findAllManager();
        //����Ϣ�洢������������
        req.setAttribute("deptAll",deptAll);
        req.setAttribute("managerAll",managerAll);
        //������������
        req.setAttribute("emp",emp);
        //ת��
        req.getRequestDispatcher("updateEmp.jsp").forward(req,resp);
    }

    private void addFind(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {

        List<Dept> depts = this.ds.list();
        List<Emp> emps = this.es.findAllManager();
        req.setAttribute("depts",depts);
        req.setAttribute("emps",emps);
        req.getRequestDispatcher("addEmp.jsp").forward(req,resp);

    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

        String pageNum = req.getParameter("pageNum");
        Page<Emp> empPage = this.es.findByPage(pageNum !=null ? Integer.valueOf(pageNum):1,3);
        req.setAttribute("empPage",empPage);
        //����
        req.getRequestDispatcher("showallemp.jsp").forward(req, resp);
    }

    protected void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
       req.setCharacterEncoding("utf-8");
        String empno=req.getParameter("empno");
        String ename=req.getParameter("ename");
        String job=req.getParameter("job");
        String mgr = req.getParameter("mgr");
        String hiredate = req.getParameter("hiredate");
        String sal = req.getParameter("sal");
        String comm = req.getParameter("comm");
        String deptno = req.getParameter("deptno");
        Dept dept = new Dept();
        dept.setDeptno(Integer.valueOf(deptno));
        Emp emp=new Emp(
                Integer.valueOf(empno),
                ename,
                job,
                Integer.valueOf(mgr),
                DateFormat.stringToDate(hiredate),
                Double.valueOf(sal),
                Double.valueOf(comm),
                dept);
        //����
        String info=es.insertEmp(emp);
        req.setAttribute("info",info);
        req.getRequestDispatcher("message.jsp").forward(req,resp);

    }
}
