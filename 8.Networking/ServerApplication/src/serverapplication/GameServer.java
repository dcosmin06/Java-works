/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Cosmin
 */
public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;
    
    
    public void init() throws IOException{
        serverSocket = new ServerSocket(PORT);
        running = true;
    }
    
    
    public void waitForClients() throws IOException{
        while(running){
            System.out.println("Wait for a client...");
            Socket socket = serverSocket.accept();
            new ClientThread(socket, this).start();
        }
    }
    
    
    public void stop() throws IOException{
        this.running = false;
        serverSocket.close();
    }
}
