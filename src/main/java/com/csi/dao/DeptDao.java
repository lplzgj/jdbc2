package com.csi.dao;

import com.csi.domain.Dept;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao {

    //���벿�ŵķ���
    int insert(Dept dept);
    //ɾ�����ŵķ���  id
    int delete(int id);
    //�޸Ĳ��ŵķ���
    int update(Dept dept);
    //��ѯ���в���
    List<Dept> selectAll();
    //����id��ѯ������Ϣ
    Dept selectById(int id);
    //�������Ʋ�ѯ������Ϣ
    Dept selectByName(String name);
    //ģ����ѯ������Ϣ�ķ���
    List<Dept> selectByLikeName(String name);

}
