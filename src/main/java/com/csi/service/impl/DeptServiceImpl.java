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
                return "�˱���Ѿ������޷�����ע��";
            }
            if (this.dao.selectByName(dept.getDname())!=null){
                return "�˲����Ѿ������޷�����ע��";
            }
            return this.dao.insert(dept)>0?"��ӳɹ�":"��ӳɹ�";
        }catch (Exception e){
            return "�����ʽ����ȷ";
        }

    }

    @Override
    public String delete(int deptno){

        return this.dao.delete(deptno)>0?"ɾ���ɹ�":"ɾ��ʧ��";
    }

    @Override
    public String update(Dept dept){
        return this.dao.update(dept)>0?"�޸ĳɹ�":"�޸�ʧ��";
    }

    @Override
    public Dept findById(int deptno){
        Dept dept = null;
        dept=this.dao.selectById(deptno);
        return dept;
    }
}
