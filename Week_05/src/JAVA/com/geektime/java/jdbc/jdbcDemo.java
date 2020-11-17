package com.geektime.java.jdbc;

import java.sql.*;

public class jdbcDemo {

    public static void main(String[] args) {
        //数据库连接对象
        Connection connection = null;
        //SQL statement对象
        Statement statement = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功！");
            //2.创建连接对象
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/nacos_config?characterEncoding=UTF-8","root","123456");
            System.out.println("连接成功,获取连接对象: "+connection);

            //3.创建Statement对象
            statement = connection.createStatement();
            String sql = "select * from users where username='nacos'";
            ResultSet resultSet = statement.executeQuery(sql);
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

