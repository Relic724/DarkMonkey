/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jme3.netbeans.plaf.darkmonkey;

import java.util.List;
import javax.swing.UIManager;
import org.openide.modules.ModuleInstall;
import org.openide.util.NbPreferences;

/**
 * This Installer class just checks to make sure that 
 * all required resources are in the system. It changes
 * over to the new look on install() only. It also 
 * makes sure that required fonts are loaded on startup. 
 * @author charles
 */
public class Installer extends ModuleInstall {

    @Override
    public void restored(){
        // Check and see if Required fonts are installed
        boolean isRequiredFontsInstalled = false;
        
        // Install DarkMonkey LaF into *JRE*... needs to be done each boot up, 
        // so it is available to netbeans.
        
        UIManager.installLookAndFeel(new UIManager.LookAndFeelInfo(
            new DarkMonkeyLookAndFeel().getName(), 
            DarkMonkeyLookAndFeel.class.getName()));
        
        
    }

}
