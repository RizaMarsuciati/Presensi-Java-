/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Riza
 */
public class ManageConnection {
      public static Connection GetOpenConnection() throws SQLException
    {
    Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sekolah","root","");
    return con;
    }
}
