/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication;

import java.io.IOException;

/**
 *
 * @author Cosmin
 */
public class ClientApplication {

    
    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        while(true){
            String request = client.readFromKeyboard();
            if(request.equalsIgnoreCase("exit")){
                break;
            }else{
                client.sendRequestToServer(request);
            }
        }   
    }
}
