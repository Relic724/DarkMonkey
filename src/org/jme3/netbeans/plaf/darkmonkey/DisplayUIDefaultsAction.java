/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jme3.netbeans.plaf.darkmonkey;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.TreeSet;
import java.text.Collator;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;

/**
 *
 * @author charles
 */
@ActionRegistration( displayName = "DisplayUIDefaults"
)
@ActionID(category = "DarkMonkey",
        id="displayUIDefaults")
public class DisplayUIDefaultsAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFileChooser userChoice = new JFileChooser();
                File writeFile = null;
                
                int checkReturn = userChoice.showSaveDialog(userChoice);
                if(checkReturn == JFileChooser.APPROVE_OPTION){
                    writeFile = userChoice.getSelectedFile();
                }
                UIDefaults defaults = UIManager.getDefaults( );
                Collection<String> sortedKeys = new TreeSet<String>(Collator.getInstance());
                for( Enumeration en = defaults.keys(); en.hasMoreElements(); ) {
                    String tempString = en.nextElement().toString();
                    sortedKeys.add(tempString);
                }
                if(writeFile != null){
                    FileWriter outputStream;
                    try{
                        outputStream = new FileWriter(writeFile);
                        for(String key : sortedKeys){
                            Object tempO;
                            tempO = UIManager.get(key);
                            if(tempO != null){
                                key = key + ": " + tempO.toString() + String.format("%n");
                            } else
                            key = key + ": " + UIManager.getString(key) + String.format("%n");
                            outputStream.write(key);
                        }
                        outputStream.close();
                    } catch(IOException ioe) {
                    } 
                } else {
                    for(String key : sortedKeys){
                        key = key + ": " + UIManager.getString(key) + String.format("%n");
                        System.out.print(key);
                    }
                }
            }
        });
     }
    
}
