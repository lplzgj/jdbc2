package com.csi.test;

import com.csi.util.DBUtil;
import com.csi.util.JDBCUtils;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
//        JDBCUtils jdbcUtils = new JDBCUtils();
//        System.out.println(jdbcUtils.getConnection());
        System.out.println(DBUtil.getConnection());
    }
}
