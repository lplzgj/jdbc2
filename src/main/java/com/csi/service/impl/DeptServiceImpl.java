package com.csi.service.impl;

import com.csi.dao.DeptDao;
import com.csi.dao.impl.DeptDaoImpl;
import com.csi.domain.Dept;
import com.csi.service.DeptService;

import java.sql.SQLException;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptDao dao;

    public DeptServiceImpl(){
        this.dao = new DeptDaoImpl();
    }
    @Override
    public List<Dept> list(){

        List<Dept> depts = null;
        depts=this.dao.selectAll();
        return depts;
    }

    @Override
    public String add(Dept dept){
        try {
            if (this.dao.selectById(dept.getDeptno())!=null){
                return "此编号已经存在无法进行注册";
            }
            if (this.dao.selectByName(dept.getDname())!=null){
                return "此部门已经存在无法进行注册";
            }
            return this.dao.insert(dept)>0?"添加成功":"添加成功";
        }catch (Exception e){
            return "输入格式不正确";
        }

    }

    @Override
    public String delete(int deptno){

        return this.dao.delete(deptno)>0?"删除成功":"删除失败";
    }

    @Override
    public String update(Dept dept){
        return this.dao.update(dept)>0?"修改成功":"修改失败";
    }

    @Override
    public Dept findById(int deptno){
        Dept dept = null;
        dept=this.dao.selectById(deptno);
        return dept;
    }
}
