package employee.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            //Driver Registry
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "gltmysql@77");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
