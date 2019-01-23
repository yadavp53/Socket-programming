/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dbutil.DBConnection;
import pojo.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pankaj
 */
public class UsersDAO {
        public static boolean verifyUser(Users u)throws SQLException
    {
    Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userID=? and password=?");
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
      ResultSet  rs=ps.executeQuery();
        if(rs.next())
            return true;
        else 
            return false;
        }
}
