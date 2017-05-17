/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication;

import java.net.Socket;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Cosmin
 */
public class GameClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    
    
    public String readFromKeyboard(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
    
    
    public void sendRequestToServer(String request){
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        
        try {
            socket = new Socket(SERVER_ADDRESS, PORT);
            out = new PrintWriter(socket.getOutputStream(),true);
            String cerere = request;
            out.println(cerere);
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String raspuns = in.readLine();
            System.out.println(raspuns);
        } catch (IOException ex) {
           System.err.println(ex);
        }finally{
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
