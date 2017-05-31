/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import commands.DisplayLocalesCommand;
import commands.LocaleInfoCommand;
import java.awt.Font;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import commands.SetLocaleCommand;
/**
 *
 * @author Cosmin
 */
public class LocaleExplorer {
     private final String baseName = "resources.Messages";
     private Locale locale;
     private ResourceBundle resourceBundle;

    public void run() {
        setLocale("en-US");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message("prompt"));
            String command = scanner.nextLine();
            if (command.equals("exit")) break;            
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "locales" : displayLocales(); break;
                case "display-locales.command" : new DisplayLocalesCommand().run(this); break;
                case "set"     : setLocale(params[1]); break;
                case "set-locale.command"  : new SetLocaleCommand().run(this, params[1]); break;
                case "info"    : localeInfo(); break;
                case "locale-info.command" : new LocaleInfoCommand().run(this); break;
                default        : System.out.println(message("invalid"));
            }
        }
    }
    
    private String message(String key, String ... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);        
        return message;
    }
    
    
    public void setLocale(String languageTag) {
        this.locale = Locale.forLanguageTag(languageTag);
        this.resourceBundle = ResourceBundle.getBundle(baseName, locale);
        System.out.println(message("locale.set", languageTag));
    }
    
    
     public void displayLocales() {
        System.out.println(message("locales"));
        Locale available[] = Locale.getAvailableLocales();
        for(Locale locale : available){
           String aux = locale.getDisplayCountry() + "  " + locale.getDisplayLanguage(locale);
           System.out.println(aux);
        }
    }
     
     
     public void localeInfo() {
        System.out.println(message("info"));
        System.out.println(locale);
        String printCountry = "Country: " + locale.getDisplayCountry() +"(" + locale.getDisplayCountry(locale) + ")";
        String printLanguage ="Language: " + locale.getDisplayLanguage() + "(" + locale.getDisplayLanguage(locale) + ")";   
        Currency currency = Currency.getInstance(locale);
        String printCurrency = "Currency: " + currency;
       
        String content = printCountry + "\n" + printLanguage + "\n" + printCurrency + "\n";
        content = content + "Week days: ";
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();
         for (DayOfWeek dayOfWeek : dayOfWeeks) {
             content = content + dayOfWeek.getDisplayName(TextStyle.FULL, locale)+' ';
         }
        
        content = content + "\n" + "Months: ";
        Month[] months = Month.values();
         for (Month month : months) {
             content = content + month.getDisplayName(TextStyle.FULL, locale)+' ';
         }
        
        content = content + "\n" + "Today: ";
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String formattedDate = df.format(new Date());
        content = content + formattedDate;
        
        JFrame f = new JFrame("Locale informations");
        JPanel upperPanel = new JPanel();
        f.getContentPane().add(upperPanel, "North");
        JTextArea textArea = new JTextArea(content, 20, 20);
        textArea.setEditable(false);
        textArea.setFont(new Font("Serif", Font.BOLD, 16));
        upperPanel.add(textArea);
        
        f.pack();
        f.setVisible(true);
     }
}