package com.geektime.java.homework02;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ShardingSphere1Test {
    @Resource
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        Connection con = null;
        try {
            con = dataSource.getConnection();
            Statement st = con.createStatement();

            //从slave0读数据
            ResultSet rs = st.executeQuery("select * from stores limit 5");
            while (rs.next()) {
                System.out.println(rs.toString());
            }

            //写入master
            st.executeUpdate("insert into stores (name, description) VALUES (\"name103\", \"description103\");");

            //从master读数据
            rs = st.executeQuery("select * from stores limit 5");
            while (rs.next()) {
                System.out.println(rs.getString(1) + "|" + rs.getString(2));
            }

            st.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
