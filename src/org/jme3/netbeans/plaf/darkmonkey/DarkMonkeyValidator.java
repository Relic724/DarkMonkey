/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jme3.netbeans.plaf.darkmonkey;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import org.openide.modules.OnStart;
import org.openide.windows.OnShowing;

/**
 *
 * @author charles
 */
@OnStart
public class DarkMonkeyValidator implements Runnable{

    @Override
    public void run() {
        //assert EventQueue.isDispatchThread();
        //JOptionPane.showMessageDialog(null,"Hello from the Validator");
    }
    
}
