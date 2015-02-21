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
import java.awt.Image;
import java.awt.image.BandedSampleModel;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferFloat;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
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
        {
            w = 18;
            h = 18;
            preProcessed = null;
        } 
        
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
            BufferedImage bi = DMUtils.loadImagefromJar(this, "icons/nehonC2.png");
            // start the experiments!
            
            Color[] normColorSet = {null, DarkMonkeyLookAndFeel.getWhite(), 
                DarkMonkeyLookAndFeel.getControlShadow(), DarkMonkeyLookAndFeel.getPrimaryControl()};
            bi = palletSwapARGB8(normColorSet, DarkMonkeyLookAndFeel.getWhite(), bi);
            // end experiment, back to old code
            ImageIcon ii = new ImageIcon(bi);
            Image scaled = ii.getImage();
            ImageIcon preProcess = new ImageIcon(scaled.getScaledInstance(w, h, Image.SCALE_SMOOTH));
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
            
            BufferedImage bi = DMUtils.loadImagefromJar(this, "icons/nehonE2.png");
            Color[] normColorSet = { DarkMonkeyLookAndFeel.getWhite(), 
                null, DarkMonkeyLookAndFeel.getPrimaryControl()};
            bi = palletSwapARGB8(normColorSet, DarkMonkeyLookAndFeel.getWhite(), bi);
            
            ImageIcon ii = new ImageIcon(bi);
            Image scaled = ii.getImage();
            
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
    
    
    public static BufferedImage palletSwapARGB8 (Color[] colorSet, Color clearToColor, BufferedImage argbMappedBufferedImage){
        if(argbMappedBufferedImage == null) return null; //S.E.P.
        
        final Color BLACK_NO_ALPHA = new Color(0x00000000);
        final Color WHITE_NO_ALPHA = new Color(0x00FFFFFF);
        final int ALPHA = 3; // this is some static mapping for...
        final int RED = 0; // readability in the following...
        final int GREEN = 1; // Magic code section of band processing.
        final int BLUE = 2;
        final int[] orderedBands = {ALPHA,RED,GREEN,BLUE};
        //first we prep a cmap with blank passes and 
        Color[] cMap = {BLACK_NO_ALPHA,BLACK_NO_ALPHA,BLACK_NO_ALPHA,BLACK_NO_ALPHA};
        if(colorSet != null){  //if we get a null colorSet... it's all mapped to clear.
            if(colorSet.length > cMap.length){ // if colorSet is more than 4, we only proces  up to 4
                for(int i = 0; i < cMap.length; i++) 
                    if(colorSet[i] != null)
                        cMap[orderedBands[i]] =  colorSet[i]; // and finally, if any of the Colors are null... invisible pass...
            } else {
                int startOffset = 0;
                if(colorSet.length < 4) // if less than standard size, assume RGB model
                    startOffset++; // and "blank" the alpha color pass.
                for(int i = 0; i < colorSet.length; i++) 
                    if(colorSet[i] != null)
                        cMap[orderedBands[i+startOffset]] =  colorSet[i];
            }
        }
        //Next we'll switch to Rasters to easily handle floating point precision
        // operations upon the individual channels.

        WritableRaster outRaster, inRaster;
        int w = argbMappedBufferedImage.getWidth();
        int h = argbMappedBufferedImage.getHeight();
        BandedSampleModel inSM = new BandedSampleModel(DataBuffer.TYPE_FLOAT,w,h,4);
        DataBufferFloat inDBF = new DataBufferFloat((w * h), 4);//4 banks, and total size 
        inRaster = Raster.createWritableRaster(inSM, inDBF, null); // that null just means point 0, 0 (top/left)
        outRaster = inRaster.createCompatibleWritableRaster(w,h);
        float[] cMaptoFlArray, outColortoFlArray, clearColortoFlArray;
        float inBandAsAlpha;
        Color paletteColor;
        // now we convert from W/E the argbMappedBufferedImage's format to 
        // our normalized [0f..1f] RGBA raster
        outColortoFlArray = new float[]{0f,0f,0f,0f}; // or new float[4]... w/e
        clearColortoFlArray = clearToColor.getRGBComponents(new float[4]);
        clearColortoFlArray[ALPHA] = 0f;
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                int packedPixel = argbMappedBufferedImage.getRGB(x, y);
                int testing = 0;
                float ftesting = 0f;
                //outColortoFlArray[ALPHA] = (((packedPixel >> 24) & 0xFF) / 255);
                testing = packedPixel;
                testing = testing >> 24;
                testing = testing & 0xFF;
                ftesting = testing;
                ftesting = ftesting / 255;
                outColortoFlArray[ALPHA] = ftesting;

                //outColortoFlArray[RED]   = (((packedPixel >> 16) & 0xFF) / 255);
                testing = packedPixel;
                testing = testing >> 16;
                testing = testing & 0xFF;
                ftesting = testing;
                ftesting = ftesting / 255;
                outColortoFlArray[RED] = ftesting;
                
                //outColortoFlArray[GREEN] = (((packedPixel >>  8) & 0xFF) / 255);
                testing = packedPixel;
                testing = testing >> 8;
                testing = testing & 0xFF;
                ftesting = testing;
                ftesting = ftesting / 255;
                outColortoFlArray[GREEN] = ftesting;
                
                //outColortoFlArray[BLUE]  = ( (packedPixel & 0xFF)        / 255);
                testing = packedPixel;
                testing = testing & 0xFF;
                ftesting = testing;
                ftesting = ftesting / 255;
                outColortoFlArray[BLUE] = ftesting;

                inRaster.setPixel(x, y, outColortoFlArray);
                outRaster.setPixel(x, y, clearColortoFlArray);
                //outRaster.setPixel(x, y, new float[]{1f,1f,1f,0f});
                /*               
                inRaster.setSample(x, y, ALPHA, outColortoFlArray[ALPHA]);
                inRaster.setSample(x, y, RED, outColortoFlArray[RED]);
                inRaster.setSample(x, y, GREEN, outColortoFlArray[GREEN]);
                inRaster.setSample(x, y, BLUE, outColortoFlArray[BLUE]);
                */           
            }
        }
        // next, we process all bands in order - a "band" being one channel of A,R,G,B.
        // as each band is processed the outRaster keeps getting "resampled" to apply
        // the next band properly. all values are considered normalized [0f..1f]
        for(int band : orderedBands){
            paletteColor = cMap[band];
            cMaptoFlArray = paletteColor.getRGBComponents(new float[4]);// this nullifies translucency
            if (paletteColor != BLACK_NO_ALPHA){
            for(int y = 0; y < h; y++){
                for(int x = 0; x < w; x++){
                    //inBandAsAlpha = inRaster.getSample(x, y, band);
                    inBandAsAlpha = inRaster.getSampleFloat(x, y, band);
                    outColortoFlArray = outRaster.getPixel(x, y, new float[4]);
                    outColortoFlArray[RED] = (outColortoFlArray[RED] * 
                            (1f - (inBandAsAlpha * cMaptoFlArray[ALPHA]))) + 
                            (cMaptoFlArray[RED] * (inBandAsAlpha * cMaptoFlArray[ALPHA]));
                    outColortoFlArray[GREEN] = (outColortoFlArray[GREEN] * 
                            (1f - (inBandAsAlpha * cMaptoFlArray[ALPHA]))) + 
                            (cMaptoFlArray[GREEN] * (inBandAsAlpha * cMaptoFlArray[ALPHA]));
                    outColortoFlArray[BLUE] = (outColortoFlArray[BLUE] * 
                            (1f - (inBandAsAlpha * cMaptoFlArray[ALPHA]))) + 
                            (cMaptoFlArray[BLUE] * (inBandAsAlpha * cMaptoFlArray[ALPHA]));

                    outColortoFlArray[ALPHA] = (outColortoFlArray[ALPHA] * 
                            (1f - (inBandAsAlpha * cMaptoFlArray[ALPHA]))) + 
                            (cMaptoFlArray[ALPHA] * (inBandAsAlpha * cMaptoFlArray[ALPHA]));
                    
                    outRaster.setPixel(x, y, outColortoFlArray);
                }
            }}
        }
        
        //then we convert n' ship
        BufferedImage returnBI = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        for(int y = 0; y < h; y++){
            for(int x = 0; x < w; x++){
                outColortoFlArray = outRaster.getPixel(x,y, new float[4]);
                int packedColor =   ((int)(outColortoFlArray[ALPHA] * 255f) << 24) |
                                    ((int)(outColortoFlArray[RED]   * 255f) << 16) |
                                    ((int)(outColortoFlArray[GREEN] * 255f) << 8 ) |
                                    ((int)(outColortoFlArray[BLUE]  * 255f));
                returnBI.setRGB(x, y, packedColor);
            }
        }
        
        return returnBI;
    }

    public static BufferedImage palletSwapARGB8 (Color[] colorSet, BufferedImage argbMappedBufferedImage){
        Color clearToColor = new Color(0x00000000); // BLACK_NO_ALPHA;
        return palletSwapARGB8(colorSet, clearToColor, argbMappedBufferedImage);
    }


}
