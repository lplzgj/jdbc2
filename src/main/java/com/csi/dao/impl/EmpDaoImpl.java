package com.csi.dao.impl;


import com.csi.dao.EmpDao;
import com.csi.domain.Dept;
import com.csi.domain.Emp;
import com.csi.domain.Page;
import com.csi.util.DBUtil;
import com.csi.util.JDBCUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {


    public int insertEmp(Emp emp) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();
        String sql = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)values (?,?,?,?,?,?,?,?)" ;
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,emp.getEmpno());
        ps.setString(2,emp.getEname());
        ps.setString(3,emp.getJob());
        ps.setInt(4,emp.getMgr());
        ps.setObject(5,emp.getHiredate());
        ps.setDouble(6,emp.getSal());
        ps.setDouble(7,emp.getComm());
        ps.setInt(8,emp.getDept().getDeptno());

        int num = ps.executeUpdate();

        jdbcUtils.release(ps,connection);
        return num;
    }

    public int delEmpByEmpNo(int id) throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();
        String sql="delete from emp where empno=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1,id);

        int num=ps.executeUpdate();
        jdbcUtils.release(ps,connection);
        return num;
    }

    public int updateEmp(Emp emp) throws SQLException {
        JDBCUtils jdbcUtils = new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();
        String sql="update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?  ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setString(2,emp.getJob());
        ps.setInt(3,emp.getMgr());
        ps.setObject(4,emp.getHiredate());
        ps.setDouble(5,emp.getSal());
        ps.setDouble(6,emp.getComm());
        ps.setInt(7,emp.getDept().getDeptno());
        ps.setInt(8,emp.getEmpno());

        int num= ps.executeUpdate();
        jdbcUtils.release(ps,connection);
        return num;
    }
    private Double format(Object o){
        if (o!=null){
            return Double.valueOf(o.toString());
        }else {
            return null;
        }
    }

    public List<Emp> findAllEmp() throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();
        String sql="select * from  emp e,dept d where e.deptno =d.deptno";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps=new ArrayList<Emp>();
        while (rs.next()){
            Emp emp =new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setMgr(rs.getInt(4));
            emp.setHiredate(rs.getDate(5));
            emp.setSal(rs.getDouble(6));
            emp.setComm(this.format(rs.getObject(7)));
            emp.setDept(new Dept(rs.getInt(8),rs.getString(9),rs.getString(10)));

            emps.add(emp);
        }
        jdbcUtils.release(rs,ps,connection);
        return emps;
    }

    public Emp findEmpByEmpNoAndName(int id,String name) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();
        String sql="select * from emp e,dept d where empno=? and ename=? and e.deptno=d.deptno";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,name);
        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            Emp emp =new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setMgr(rs.getInt(4));
            emp.setHiredate(rs.getDate(5));
            emp.setSal(rs.getDouble(6));
            emp.setComm(this.format(rs.getObject(7)));
            emp.setDept(new Dept(rs.getInt(8),rs.getString(9),rs.getString(10)));
            return emp;
        }
        jdbcUtils.release(rs,ps,connection);
        return null;
    }

    @Override
    public Emp findEmpByEmpNo(int id) throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();
        String sql="select * from emp e,dept d where empno=? and e.deptno=d.deptno";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            Emp emp =new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setMgr(rs.getInt(4));
            emp.setHiredate(rs.getDate(5));
            emp.setSal(rs.getDouble(6));
            emp.setComm(this.format(rs.getObject(7)));
            emp.setDept(new Dept(rs.getInt(8),rs.getString(9),rs.getString(10)));
            return emp;
        }
        jdbcUtils.release(rs,ps,connection);
        return null;
    }

    public List<Emp> selectManager() throws SQLException {
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection connection = jdbcUtils.getConnection();
        String sql="select * from  emp e,dept d where e.deptno =d.deptno and empno in (select distinct mgr from emp where mgr is not null)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Emp> emps=new ArrayList<Emp>();
        while (rs.next()){
            Emp emp =new Emp();
            emp.setEmpno(rs.getInt(1));
            emp.setEname(rs.getString(2));
            emp.setJob(rs.getString(3));
            emp.setMgr(rs.getInt(4));
            emp.setHiredate(rs.getDate(5));
            emp.setSal(rs.getDouble(6));
            emp.setComm(this.format(rs.getObject(7)));
            emp.setDept(new Dept(rs.getInt(8),rs.getString(9),rs.getString(10)));

            emps.add(emp);
        }
        jdbcUtils.release(rs,ps,connection);
        return emps;
    }

    private int count(){
        Connection conn =  DBUtil.getConnection();
        String sql = "select count(1) from emp";
        PreparedStatement psmt = DBUtil.getPstmt(conn,sql);
        ResultSet rs = DBUtil.query(psmt);
        try {
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Page<Emp> selectByPage(int pageNum, int pageSize) {
        Page<Emp> page = new Page<>(pageNum,pageSize);
        page.setTotalData(this.count());
        Connection conn = DBUtil.getConnection();
        String sql = "select * from emp e,dept d where e.deptno=d.deptno limit ?,?";
        PreparedStatement psmt = DBUtil.getPstmt(conn,sql,page.start(),page.getPageSize());
        ResultSet rs = DBUtil.query(psmt);
        List<Emp> list = new ArrayList<>();
        try {
            while (rs.next()){
                Emp emp = new Emp(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getDouble(6),
                        this.format(rs.getObject(7)),
                        new Dept(
                                rs.getInt(8),
                                rs.getString(9),
                                rs.getString(10)
                        )
                        );
                list.add(emp);
            }
            page.setData(list);
            return page;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
