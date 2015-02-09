/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jme3.netbeans.plaf.darkmonkey;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Tools",
        id = "org.jme3.netbeans.plaf.darkmonkey.DarkMonkeyAction"
)
@ActionRegistration(
        displayName = "#CTL_DarkMonkeyAction"
)
@ActionReference(path = "Menu/Tools", position = 1800)
@Messages("CTL_DarkMonkeyAction=DarkMonkey")

public final class DarkMonkeyAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                boolean dmLAFDetected = false;
                UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
                String messageString = "";
                String dmLAFString = DarkMonkeyLookAndFeel.class.getName();
                for(UIManager.LookAndFeelInfo installedLookAndFeel : installedLookAndFeels){
                    messageString += installedLookAndFeel.getClassName();
                    if(installedLookAndFeel.getClassName().equals(DarkMonkeyLookAndFeel.class.getName())){
                        messageString += " -BINGO!-";
                    } else {
                        messageString += " ...";
                    }
                    messageString += "\n";  
                }
                messageString += "\n I looked for: \n" + dmLAFString;

                JOptionPane.showMessageDialog(null, messageString);
                
                
                messageString = "Searching for necessary fonts: \n";
                boolean isFontsFound = false;
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                String[] registeredFontFamilies = ge.getAvailableFontFamilyNames();
                for(String registeredFontFamily : registeredFontFamilies){
                    if(registeredFontFamily.startsWith("DejaVu Sans")){
                        messageString += ".. "+registeredFontFamily + "\n";
                        isFontsFound = true;
                    }
                }
                if(isFontsFound){
                    messageString += "\n-Fonts found, yay!-\n";
                } else
                    messageString += "\n DejaVu Sans family not found. \n" 
                            + "It might look funny, but should be close.";
                JOptionPane.showMessageDialog(null, messageString);
                
                if(JOptionPane.showConfirmDialog(null, "Use the Voodoo Magic?", 
                        dmLAFString, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    try {
                        UIManager.setLookAndFeel(new DarkMonkeyLookAndFeel());
                    }
                    catch (Exception e) {
                        
                    }
                    
                    SwingUtilities.updateComponentTreeUI(WindowManager.getDefault().getMainWindow());
                }

            }
        
        });
    }
}
