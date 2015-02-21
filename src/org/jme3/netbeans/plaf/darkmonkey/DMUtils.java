/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jme3.netbeans.plaf.darkmonkey;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.NoSuchFileException;
import javax.imageio.ImageIO;

/**
 *  I figured it would be best to have a Utilities type class to store the 
 *  Methods I commonly use. Resources, registering stuff, resolving, transforming
 * and so on...
 *
 * @author charles
 */
public class DMUtils {
    
    /**
     * This method is geared to receive relative paths and convert them to runtime 
     * absolute paths that work with netbeans' multi module system or stand alone. 
     * It checks against the absolute jar location of the instance in refObj, 
     * and synthesizes a new absolute path with the relative path as an extension
     * of the directory that the refObj's jar is located.
     * <p>Usage example:<br>myImage = new 
     * Image(DMUtils.relpath(this, "icons/myPng.png");<br>
     * 
     * looks for ....  [Method and JavaDoc under construction - Do not use]
     *
     * @param relativePath
     * @return
     * @throws NoSuchFileException 
     */
    public static String relpath(String relativePath){
        final File f = new File(DMUtils.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String returnString;
        int i;
        returnString = f.getPath();
        i = returnString.indexOf("org-jme3-netbeans");
        returnString = returnString.substring(0,i);
        returnString = returnString.replace(File.separatorChar, '/')  + relativePath;
        File check = new File(returnString);
        
        
        
        return returnString;
        
        
    }
    
    /**
     * [JavaDoc under Construction]
     * @param refObj
     * @param fileName
     * @return 
     */
    public static BufferedImage loadImagefromJar(Object refObj, String fileName){
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(refObj.getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            // File is probably referenced wrong or "mispleled"... lol.
            e.printStackTrace();
        }
        return bi;
    }
}
