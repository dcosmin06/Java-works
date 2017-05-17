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
public class MatchController {
    private int matchID = 0;
    public void create(int firstTeam, int secondTeam, int firstGoals, int secondGoals) throws SQLException{
        Connection con = Database.getConnection();
        PreparedStatement pstmt = con.prepareStatement("insert into matches(id,team_id1,team_id2,goals1,goals2) values(?,?,?,?,?)");
        pstmt.setInt(1,matchID);
        pstmt.setInt(2,firstTeam);
        pstmt.setInt(3,secondTeam);
        pstmt.setInt(4,firstGoals);
        pstmt.setInt(5,secondGoals);
        matchID++;
        pstmt.executeUpdate();
        if(firstGoals > secondGoals){
            TeamController tc = new TeamController();
            tc.addPoints(firstTeam, 3);
        }
        if(firstGoals < secondGoals){
            TeamController tc = new TeamController();
            tc.addPoints(secondTeam, 3);
        }
        if(firstGoals == secondGoals){
            TeamController tc = new TeamController();
            tc.addPoints(firstTeam, 1);
            tc.addPoints(secondTeam, 1);
        }
    }
    
    
    public void printMatch(int matchID) throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select id,team_id1,team_id2,goals1,goals2 from matches where id='" + matchID + "'");
        while(rs.next()){
            int id = rs.getInt(1);
            int tid1 = rs.getInt(2);
            int tid2 = rs.getInt(3);
            int g1 = rs.getInt(4);
            int g2 = rs.getInt(5);
            System.out.println(id +" "+tid1+" "+tid2+" "+g1+" "+g2);
        }
        rs.close();
    }
    
    
    public int getMatchId(){
        return matchID;
    }
    
}
