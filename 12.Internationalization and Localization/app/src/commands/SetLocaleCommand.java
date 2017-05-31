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
public class SetLocaleCommand {
    
    public void run(LocaleExplorer localeExplorer, String languageTag){
        localeExplorer.setLocale(languageTag);
    }
}
