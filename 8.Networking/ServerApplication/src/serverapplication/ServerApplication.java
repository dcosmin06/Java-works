/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapplication;

import java.io.IOException;

/**
 *
 * @author Cosmin
 */
public class ServerApplication {

    
    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
        server.init();
        server.waitForClients();
        
    }
    
}
