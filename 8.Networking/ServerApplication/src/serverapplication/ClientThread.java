/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapplication;

import java.net.Socket;
import java.io.*;
import java.util.Objects;


/**
 *
 * @author Cosmin
 */
public class ClientThread extends Thread {
    private Socket socket = null;
    private final GameServer server;
    
    
    public ClientThread(Socket socket, GameServer server){
        this.socket = socket;
        this.server = server;
    }
    
    
    @Override
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            String response = execute(request);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(response);
            out.flush();
        } catch (IOException ex) {
            System.err.println(ex);
        }finally{
            try{
                socket.close();
            }catch(IOException e){
                System.err.println(e);
            }
        }
    }
    
    
    private String execute(String request) throws IOException{
        String auxResponse;
        boolean value = Objects.equals(request, "stop");
        if(value){
            auxResponse ="Server stopped.";
            this.server.stop();
        }
        else{
            auxResponse = "Server received the request " + request +".";
        }
        return auxResponse;
    }
    
}
