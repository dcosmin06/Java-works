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
public class TeamController {
    private int teamID = 0;
    private int points = 0;
    public void create(String teamName) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into teams(id,name,points) values(?,?,?)");
        pstmt.setInt(1,teamID);
        pstmt.setString(2, teamName);
        pstmt.setInt(3, 0);
        teamID++;
        pstmt.executeUpdate();
    }
    
    public int getPoints(int teamId) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select points from teams where id='" + teamId + "'");
        Integer points = rs.next() ? rs.getInt(1) : null;
        rs.close();
        return points;
    }
    
    
    public void addPoints(int teamId, int number) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        int auxPoints = getPoints(teamId) + number;
        ResultSet rs = stmt.executeQuery("update teams set points='" + auxPoints + "'" + " where id='" + teamId + "'");
    }
    
    
    public Integer findByName(String teamName) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select id from teams where name='" + teamName + "'");
        Integer id = rs.next() ? rs.getInt(1) : null;
        rs.close();
        return id;
    }
    
    
    public String findById(int id) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select name from teams where id='" + id + "'");
        String teamName = rs.next() ? rs.getString(2) : null;
        rs.close();
        return teamName;
    }
}
