package com.csi.dao.impl;

import com.csi.dao.DeptDao;
import com.csi.domain.Dept;
import com.csi.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {

    @Override
    public int insert(Dept dept) {
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn, "insert into dept(deptno,dname,loc) values(?,?,?)",
                dept.getDeptno(), dept.getDname(), dept.getLoc());
        //执行插入操作
        int i = DBUtil.update(pstmt);
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return i;
    }

    @Override
    public int delete(int id) {
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"delete from dept where deptno=?",id);
        //执行插入操作
        int i = DBUtil.update(pstmt);
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return i;
    }

    @Override
    public int update(Dept dept) {
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"update dept set dname=?,loc=? where  deptno=?",dept.getDname(),dept.getLoc(),dept.getDeptno());
        //执行插入操作
        int i = DBUtil.update(pstmt);
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return i;
    }

    @Override
    public List<Dept> selectAll(){
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from dept");
        ResultSet rs = DBUtil.query(pstmt);
        List<Dept> deptList = new ArrayList<>();
        try {
            while (rs.next()){
                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                deptList.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return deptList;
    }

    @Override
    public Dept selectById(int id){
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from dept where deptno=?",id);
        ResultSet rs = DBUtil.query(pstmt);
        Dept dept = null;
        try {
            if (rs.next()){
                dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return dept;
    }

    @Override
    public Dept selectByName(String name){
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from dept where dname=?",name);
        ResultSet rs = DBUtil.query(pstmt);
        Dept dept = null;
        try {
            if (rs.next()){
                dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return dept;
    }

    @Override
    public List<Dept> selectByLikeName(String name){
        //调用Dbutil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from dept where dname like '%' ? '%'",name);
        ResultSet rs = DBUtil.query(pstmt);
        List<Dept> deptList = new ArrayList<>();
        try {
            while (rs.next()){
                Dept dept = new Dept();

                    dept.setDeptno(rs.getInt("deptno"));

                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
                deptList.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭资源
        DBUtil.close(conn, pstmt, null);
        return deptList;
    }
}
