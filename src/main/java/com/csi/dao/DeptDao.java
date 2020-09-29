package com.csi.dao;

import com.csi.domain.Dept;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao {

    //插入部门的方法
    int insert(Dept dept);
    //删除部门的方法  id
    int delete(int id);
    //修改部门的方法
    int update(Dept dept);
    //查询所有部门
    List<Dept> selectAll();
    //根据id查询部门信息
    Dept selectById(int id);
    //根据名称查询部门信息
    Dept selectByName(String name);
    //模糊查询部门信息的方法
    List<Dept> selectByLikeName(String name);

}
