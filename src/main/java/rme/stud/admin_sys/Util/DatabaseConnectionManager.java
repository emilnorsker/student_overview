package rme.stud.admin_sys.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnectionManager {

    private static Connection conn;
    public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =DriverManager.getConnection(
                    "jdbc:mysql://den1.mysql3.gear.host:3306/studenttest1","studenttest1","Hu0qb27-TP5-");
        }catch(Exception e){ System.out.println(e);}
        return conn;
    }
}