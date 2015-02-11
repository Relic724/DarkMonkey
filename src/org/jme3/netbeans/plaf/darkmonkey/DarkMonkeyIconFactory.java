/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jme3.netbeans.plaf.darkmonkey;

import com.nilo.plaf.nimrod.NimRODIconFactory;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.plaf.UIResource;
/**
 * This class provides for overrides on the system Icons from the
 * NimROD look and feel
 * @author charles
 */
public class DarkMonkeyIconFactory extends NimRODIconFactory{
    private static Icon treeCollapsedIcon;
    private static Icon treeExpandedIcon;
    
    public static Icon getTreeCollapsedIcon(){
        if(treeCollapsedIcon == null){
            treeCollapsedIcon = new TreeCollapsedIcon();
        }
        
        return treeCollapsedIcon;
    }
    public static Icon getTreeExpandedIcon(){
        if(treeExpandedIcon == null){
            treeExpandedIcon = new TreeExpandedIcon();
        }
        
        return treeExpandedIcon;
    }
    
    private static class TreeCollapsedIcon implements Icon, UIResource, Serializable{
        private int w, h;
        ImageIcon preProcessed;
        
         
        public TreeCollapsedIcon(){ //maybe THIS is all I need, eh?
            w = 18;
            h = 18;
            preProcessed = null;
        }
        
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            if(preProcessed != null){
                preProcessed.paintIcon(c, g, x, y);
                return;
            }       

            //process for first time, unless this gets "uninitialized" by
            // UIResource calls;
            Image scaled = new ImageIcon("Resources/nextTry.png").getImage();
            ImageIcon preProcess = new ImageIcon(scaled.getScaledInstance(w, h, Image.SCALE_DEFAULT));
            preProcess.paintIcon(c, g, x, y);
            preProcessed = preProcess;
        }

        @Override
        public int getIconWidth() {
            return w; 
        }

        @Override
        public int getIconHeight() {
            return h; 
        }
        
    }
    
    private static class TreeExpandedIcon implements Icon, UIResource, Serializable{
        private int w, h;
        ImageIcon preProcessed;
        
         
        public TreeExpandedIcon(){ //maybe THIS is all I need, eh?
            w = 18;
            h = 18;
            preProcessed = null;
        }
        
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            if(preProcessed != null){
                preProcessed.paintIcon(c, g, x, y);
                return;
            }       

            //process for first time, unless this gets "uninitialized" by
            // UIResource calls;
            Image scaled = new ImageIcon("Resources/nextTry2.png").getImage();
            
            ImageIcon preProcess = new ImageIcon(scaled.getScaledInstance(w, h, Image.SCALE_DEFAULT));
            
            preProcess.paintIcon(c, g, x, y);
            preProcessed = preProcess;
        }

        @Override
        public int getIconWidth() {
            return w; 
        }

        @Override
        public int getIconHeight() {
            return h; 
        }
        
    }
    
//<editor-fold defaultstate="collapsed" desc="Oh god, Utility Functions..">
    public static ImageIcon palletSwapARGB8(Color[] colorSet, Icon rgbMappedIcon, boolean isRGBOnly, int blurSize){
        if(rgbMappedIcon == null) return null; // S.E.P.
        if(blurSize < 0 || blurSize > 30) return null; // there is a bit shift involved.
        
        int w, h;
        w = rgbMappedIcon.getIconWidth();
        h = rgbMappedIcon.getIconHeight();
        Color[] cMap = {Color.BLACK,Color.RED,Color.GREEN,Color.BLUE}; // for init and readability.
        
        if(colorSet != null){  //if we get a null colorSet... it's all mapped to white.
            if(colorSet.length > cMap.length){ // if some improperly sized array comes through...
                for(int i = 0; i < cMap.length; i++) if(colorSet[i] != null)
                    cMap[i] =  colorSet[i]; // and finally, if any of the Colors are null... White
            } else {
                for(int i = 0; i < colorSet.length; i++) if(colorSet[i] != null)
                    cMap[i] =  colorSet[i];
            }
        }
        
        BufferedImage sourceImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        BufferedImage returnImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = sourceImage.createGraphics();
        g2d.setBackground(new Color(0x00000000));
        g2d.clearRect(0,0,w,h);
        rgbMappedIcon.paintIcon(null, g2d, 0, 0); //transfer contents to sourceImage;
        g2d = returnImage.createGraphics(); //switch over to working on returnImage
        g2d.setBackground(new Color(0x00000000));
        g2d.clearRect(0,0,w,h);
        // now that the sourceImage is ready, time to break it down into
        // normalized "alpha" channel multipliers.
        float[][][] srcChannels = new float[4][w][h];
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                Color c1 = new Color(sourceImage.getRGB(x, y));
                float[] normChannels = c1.getColorComponents(new float[4]);
                for(int ch = 0; ch < 4; ch++){
                    int blurPower = 1<<blurSize; //note: Pi and some type of exponent...somewhere...
                    srcChannels[ch][x][y] = normChannels[ch]/blurPower;
                }
            }
        }
        
        // and now that I found out about the Color(int) and the
        // "pixel" I'll get stuff ready for that... I was sooo
        // annoyed that there isn't a Color(float[4]), but meh,
        // I usually use JME3 to avoid this type of stuff.
        final int AbM, RbM, GbM, BbM; // bitMask declaration time!
        AbM = 0xFF000000; //Alpha Channel
        RbM = 0x00FF0000; //Red Channel
        GbM = 0x0000FF00; //Green Channel
        BbM = 0x000000FF; //and Blue Channel
        // I don't need them, but they are pretty! LoL it's early in the morning
        
        //Now for the passes
        //Pass 1 - the Alpha Channel / srcChannels[3][x][y]
        //this pass may be skipped;
        if(!isRGBOnly){
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    float[] normChannels = cMap[0].getColorComponents(new float[4]);
                    int pixel = ((int)(255 * normChannels[3] * srcChannels[3][x][y])<<24)|
                            ((int)(255 * normChannels[0])<<16)|
                            ((int)(255 * normChannels[1])<<8)|
                            ((int)(255 * normChannels[2]));
                    
                    g2d.setColor(new Color(pixel));
                    g2d.drawOval(x-blurSize, y-blurSize, blurSize, blurSize);
                }
            }
        }
        
        //Pass 2-4 or 1-3 lol.
        for(int ch = 0; ch < 3; ch++){ //yeppers, don't need that alpha channel for this
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    float[] normChannels = cMap[0].getColorComponents(new float[4]);
                    int pixel = ((int)(255 * normChannels[3] * srcChannels[ch][x][y])<<24)|
                            ((int)(255 * normChannels[0])<<16)|
                            ((int)(255 * normChannels[1])<<8)|
                            ((int)(255 * normChannels[2]));
                    
                    g2d.setColor(new Color(pixel));
                    g2d.drawOval(x-blurSize, y-blurSize, blurSize, blurSize);
                }
            }
        }
        
        // whew! and done!
        
        
        return new ImageIcon(returnImage);
    }
    
//</editor-fold>
    


}
