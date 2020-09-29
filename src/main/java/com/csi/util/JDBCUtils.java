package com.csi.util;

import java.sql.*;

public class JDBCUtils {

    /**
     * 释放PreparedStatement,Connection
     */
    public void release(PreparedStatement ps,Connection conn) {
        release(ps);
        release(conn);
    }

    /**
     * 释放ResultSet,PreparedStatement,Connection
     */
    public void release(ResultSet rs,PreparedStatement ps,Connection connection) {
        release(rs);
        release(ps,connection);
    }

    private void release(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void release(Statement statement) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void release(PreparedStatement statement) {
        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void release(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



    /**
     * 获取连接的方法
     * @return java.sql.Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8&serverTimezone=UTC", "root", "111111");

        return connection ;
    }

}
