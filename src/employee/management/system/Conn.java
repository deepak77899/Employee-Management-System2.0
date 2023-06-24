package employee.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            //Step1: Registration of Driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Step2: Creating The Connection String
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "Gltsql@77");
            //Step3: Creating Statement
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//Step4: Executing mysql queries
//Step5: Closing the Connections

