package com.csi.service.impl;

import com.csi.dao.EmpDao;
import com.csi.dao.impl.EmpDaoImpl;
import com.csi.domain.Emp;
import com.csi.domain.Page;
import com.csi.service.EmpService;

import java.sql.SQLException;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao;

    public EmpServiceImpl() {

        this.empDao = new EmpDaoImpl();
    }

    public String insertEmp(Emp emp) throws SQLException {
        if (this.empDao.findEmpByEmpNoAndName(emp.getEmpno(),emp.getEname())!=null){
            return "对不起员工已录入";
        }
        return this.empDao.insertEmp(emp)>0?"录入信息成功!":"录入信息失败!";
    }

    public String delEmpByEmpNo(int id) throws SQLException {
        return this.empDao.delEmpByEmpNo(id)>0?"删除信息成功!":"删除信息失败!";
    }

    public String updateEmp(Emp emp) throws SQLException {
        return this.empDao.updateEmp(emp)>0?"更改信息成功!":"更改信息失败!";
    }

    public List<Emp> findAllEmp() throws SQLException {
        return this.empDao.findAllEmp();
    }

    @Override
    public List<Emp> findAllManager() throws SQLException {
        return this.empDao.selectManager();
    }

    public Emp findEmpByEmpNoAndEname(int id,String name) throws SQLException {
        return this.empDao.findEmpByEmpNoAndName(id,name);
    }

    @Override
    public Emp findEmpByEmpNo(int id) throws SQLException {
        return this.empDao.findEmpByEmpNo(id);
    }

    @Override
    public Page<Emp> findByPage(int pageNum, int pageSize) {
        return this.empDao.selectByPage(pageNum, pageSize);
    }

}
