package com.csi.service;

import com.csi.domain.Emp;
import com.csi.domain.Page;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {
    String insertEmp(Emp emp)throws SQLException;

    String delEmpByEmpNo(int id) throws SQLException;

    String updateEmp(Emp emp)throws SQLException;

    List<Emp> findAllEmp()throws SQLException;

    List<Emp> findAllManager() throws SQLException;

    Emp findEmpByEmpNoAndEname(int id, String name)throws SQLException;

    Emp findEmpByEmpNo(int id)throws SQLException;

    Page<Emp> findByPage(int  pageNum,int pageSize);
}
