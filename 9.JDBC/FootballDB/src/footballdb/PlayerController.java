/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cosmin
 */
public class PlayerController {
    private int playerID = 0;
    public void create(String playerName, int teamID) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into players(id,name,team_id) values(?,?,?)");
        pstmt.setInt(1,playerID);
        pstmt.setString(2, playerName);
        pstmt.setInt(3, teamID);
        playerID++;
        pstmt.executeUpdate();
    }
    
    
    public void list(int teamID) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from players where team_id='" + teamID + "'");
        while(rs.next()){
            int code = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println(code +" "+name);
        }
        rs.close();
    }
    
    
    public Integer findByName(String playerName) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select id from players where name='" + playerName + "'");
        Integer id = rs.next() ? rs.getInt(1) : null;
        rs.close();
        return id;
    }
}
