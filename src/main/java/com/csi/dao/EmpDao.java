package com.csi.dao;

import com.csi.domain.Emp;
import com.csi.domain.Page;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
    int insertEmp(Emp emp)throws SQLException;

    int delEmpByEmpNo(int id) throws SQLException;

    int updateEmp(Emp emp)throws SQLException;

    List<Emp> findAllEmp()throws SQLException;

    Emp findEmpByEmpNoAndName(int id, String name)throws SQLException;

    Emp findEmpByEmpNo(int id) throws SQLException;

    List <Emp> selectManager()throws SQLException;

    Page<Emp> selectByPage(int pageNum,int pageSize);
}
