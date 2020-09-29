package com.csi.service;

import com.csi.domain.Dept;

import java.sql.SQLException;
import java.util.List;

public interface DeptService {

    List<Dept> list();

    String add(Dept dept);

    String delete(int deptno);

    String update(Dept dept);

    Dept findById(int deptno);

}
