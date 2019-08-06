package com.company.oa.service;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;

public class TestMysqlDriver {
    public static void main(String args[])
    {

        String url = "jdbc:mysql://localhost/ssm";
        String driver = "com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
        }catch(Exception e){
            System.out.println("无法加载驱动");
        }

        try {
            Connection con = (Connection) DriverManager.getConnection(url,"root","123456");
            if(!con.isClosed())
                System.out.println("success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
