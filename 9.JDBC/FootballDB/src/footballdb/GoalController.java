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
public class GoalController {
    private int goalID = 0;
    public void create(int matchID, int playerID, int minute, int penalty) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into goals(id,match_id,player_id,minut,penalty) values(?,?,?,?,?)");
        pstmt.setInt(1,goalID);
        pstmt.setInt(2, matchID);
        pstmt.setInt(3, playerID);
        pstmt.setInt(4, minute);
        pstmt.setInt(5, penalty);
        goalID++;
        pstmt.executeUpdate();
    }
    
    
    public void printGoal(int goalID) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from matches where id='" + goalID + "'");
        rs.close();
    }
}
