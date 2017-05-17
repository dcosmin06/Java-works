/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballdb;

import java.sql.SQLException;

/**
 *
 * @author Cosmin
 */
public class FootballDB {

    public static void main(String[] args) {
        
       try{
           TeamController Teams = new TeamController();
           PlayerController Players = new PlayerController();
           MatchController matches = new MatchController();
           GoalController goals = new GoalController();
           RankingController ranks = new RankingController();
           
           Teams.create("FC Barcelona");
           Teams.create("Real Madrid");
           Teams.create("Bayern Munchen");
           Teams.create("Atletico Madrid");
           Teams.create("Borussia Dortmund");
           Database.commit();
           
           int fcbID = Teams.findByName("FC Barcelona");
           Players.create("Lionel Messi", fcbID);
           Players.create("Neymar", fcbID);
           Players.create("Luis Suarez", fcbID);
           Players.list(fcbID);
           Database.commit();
           
           int rmID = Teams.findByName("Real Madrid");
           int bmID = Teams.findByName("Bayern Munchen");
           int amID = Teams.findByName("Atletico Madrid");
           int bdID = Teams.findByName("Borussia Dortmund");
           Players.create("Ronaldo", rmID);
           Players.create("Gareth Bale", rmID);
           Players.create("Manuel Neuer", bmID);
           Players.create("Ribery", bmID);
           Players.create("Torres", amID);
           Players.create("Tiago", amID);
           Players.create("Lewandowski", bdID);
           Players.create("Gotze", bdID);
           Players.list(rmID);
           Players.list(bmID);
           Players.list(amID);
           Players.list(bdID);
           Database.commit();
           
           matches.create(rmID, bdID, 2, 1);
           goals.create(matches.getMatchId()-1, Players.findByName("Ronaldo"), 34, 0);
           goals.create(matches.getMatchId()-1, Players.findByName("Ronaldo") , 42, 1);
           goals.create(matches.getMatchId()-1, Players.findByName("Gotze"), 11, 0);
           matches.create(bmID, amID, 1, 0);
           goals.create(matches.getMatchId()-1, Players.findByName("Ribery"), 77, 0);
           matches.create(fcbID, rmID, 0, 0);
           Database.commit();

           //matches.printMatch(matches.getMatchId()-1);
           ranks.showRanks();
           Database.commit();
          
           
       }catch(SQLException e){
           System.err.println(e);
           Database.rollback();
       }finally{
           Database.closeConnection();
       }
    }
    
}
