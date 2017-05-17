/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Cosmin
 */
public class RankingController {
    
     public void showRanks() throws SQLException{
        Connection con = Database.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from teams order by points desc");
        System.out.println(" ");
        System.out.println("Rank List");
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int pid = rs.getInt(3);
            System.out.println(id +" "+name+" "+pid);
        }
        rs.close();
    }
    
}
