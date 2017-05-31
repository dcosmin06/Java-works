/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import app.LocaleExplorer;

/**
 *
 * @author Cosmin
 */
public class DisplayLocalesCommand {
    
    public void run(LocaleExplorer localeExplorer){
        localeExplorer.displayLocales();
    }
}
