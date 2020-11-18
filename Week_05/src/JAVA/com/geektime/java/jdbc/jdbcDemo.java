package com.geektime.java.jdbc;

import java.sql.*;

/**
 * java sql包下的原生接口
 */
public class jdbcDemo {

    public static void main(String[] args) {
        //数据库连接对象
        Connection connection = null;
        //SQL statement对象
//        Statement statement = null;
        //
        PreparedStatement statement = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");
            //2.创建连接对象
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/nacos_config?characterEncoding=UTF-8","root","123456");
            System.out.println("连接成功,获取连接对象: "+connection);

            //3.创建Statement对象
//            statement = connection.createStatement();
            String sql = "select * from users where username=?";
            //4.使用PreparedStatement的方式
            statement = connection.prepareStatement(sql);
            statement.setString(1,"nacos");
            ResultSet resultSet = statement.executeQuery();
            //5.批量操作 executeBatch
//            PreparedStatement ps = connection.prepareStatement("INSERT into employees values (?, ?, ?)");
//            for (n = 0; n < 100; n++) {
//
//                ps.setString(name[n]);
//                ps.setLong(id[n]);
//                ps.setInt(salary[n]);
//                ps.addBatch();
//            }
//            ps.executeBatch();

            while(resultSet.next()){
                String password = resultSet.getString("password");
                System.out.println("遍历出密码:"+password);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    }

