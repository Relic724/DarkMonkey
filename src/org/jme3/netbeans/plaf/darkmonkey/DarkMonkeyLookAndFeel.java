/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jme3.netbeans.plaf.darkmonkey;

import com.nilo.plaf.nimrod.NimRODTheme;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIDefaults;

/**
 * The DarkMonkey look and feel class Extends the Nimrod LAF, which in turn,
 * extends Metal.  The version of Nimrod used is 1.2b obtained from: <br/>
 * <a src="http://nilogonzalez.es/nimrodlf/download-en.html">
 * http://nilogonzalez.es/nimrodlf/download-en.html</a>
 * @author Charles Anderson
 */
public class DarkMonkeyLookAndFeel extends com.nilo.plaf.nimrod.NimRODLookAndFeel{
    
    public static final String dmLAFDefault = "DarkMonkey.theme";
    protected static NimRODTheme nrTheme = new NimRODTheme();
    
    public DarkMonkeyLookAndFeel(){
        super();
        NimRODTheme nt = new NimRODTheme();
                
        nt.setBlack(Color.decode("#E8EAE0"));
        nt.setWhite(Color.decode("#262626"));
        nt.setPrimary1(Color.decode("#77411D"));
        nt.setPrimary2(Color.decode("#9E5F28"));
        nt.setPrimary3(Color.decode("#948519"));
        nt.setSecondary1(Color.decode("#303030"));
        nt.setSecondary2(Color.decode("#3A3A3A"));
        nt.setSecondary3(Color.decode("#515151"));
        nt.setFrameOpacity(180);
        nt.setMenuOpacity(219);
        nt.setFont(Font.decode("DejaVu Sans Condensed-PLAIN-12"));
        
        setCurrentTheme(nt);
        
    }
    
    /**
     * This method override, getID() returns the String "DarkMonkey" for 
     * registering this Look And Feel with the UImanager.
     * @return String "DarkMonkey"
     */
    @Override
    public String getID() {
        return "DarkMonkey";
    }

    /**
     * This method override, getName() returns the String "DarkMonkey" for 
     * its Look and Feel Name. I don't know that this is important, but is
     * overridden anyway, for completion.
     * @return String "DarkMonkey"
     */
    @Override
    public String getName() {
        return "DarkMonkey";
    }

    /**
     * This method override, getDescription() returns the String 
     * "Look and Feel DarkMonkey - 2015, based on NimROD 2007" for 
     * instances of future programming that might use it as a tool tip or 
     * small descriptor in their Look and Feel modules.
     * @return String "Look and Feel DarkMonkey - 2015, based on NimROD 2007"
     */
    @Override
    public String getDescription() {
        return "Look and Feel DarkMonkey - 2015, based on NimROD 2007";
    }
    
       
    @Override
    protected void initClassDefaults( UIDefaults table) {
        super.initClassDefaults( table);
       
        /* --Here are the current Element Drawing techniques that NimROD overrides on Metal        
        table.put( "ButtonUI", "com.nilo.plaf.nimrod.NimRODButtonUI");
        table.put( "ToggleButtonUI", "com.nilo.plaf.nimrod.NimRODToggleButtonUI");
        table.put( "TextFieldUI", "com.nilo.plaf.nimrod.NimRODTextFieldUI");
        table.put( "TextAreaUI", "com.nilo.plaf.nimrod.NimRODTextAreaUI");
        table.put( "PasswordFieldUI", "com.nilo.plaf.nimrod.NimRODPasswordFieldUI");
        table.put( "CheckBoxUI", "com.nilo.plaf.nimrod.NimRODCheckBoxUI");
        table.put( "RadioButtonUI", "com.nilo.plaf.nimrod.NimRODRadioButtonUI");
        table.put( "FormattedTextFieldUI", "com.nilo.plaf.nimrod.NimRODFormattedTextFieldUI");
        table.put( "SliderUI", "com.nilo.plaf.nimrod.NimRODSliderUI");
        table.put( "SpinnerUI", "com.nilo.plaf.nimrod.NimRODSpinnerUI");
        
        table.put( "ListUI", "com.nilo.plaf.nimrod.NimRODListUI");
        table.put( "ComboBoxUI", "com.nilo.plaf.nimrod.NimRODComboBoxUI");
        table.put( "ScrollBarUI", "com.nilo.plaf.nimrod.NimRODScrollBarUI");
        table.put( "ToolBarUI", "com.nilo.plaf.nimrod.NimRODToolBarUI");
        table.put( "ProgressBarUI", "com.nilo.plaf.nimrod.NimRODProgressBarUI");
        table.put( "ScrollPaneUI", "com.nilo.plaf.nimrod.NimRODScrollPaneUI");
        
        table.put( "TabbedPaneUI", "com.nilo.plaf.nimrod.NimRODTabbedPaneUI");
        table.put( "TableHeaderUI", "com.nilo.plaf.nimrod.NimRODTableHeaderUI");
        table.put( "SplitPaneUI", "com.nilo.plaf.nimrod.NimRODSplitPaneUI");
        
        table.put( "InternalFrameUI", "com.nilo.plaf.nimrod.NimRODInternalFrameUI");
        table.put( "DesktopIconUI", "com.nilo.plaf.nimrod.NimRODDesktopIconUI");
        
        table.put( "ToolTipUI", "com.nilo.plaf.nimrod.NimRODToolTipUI");
        
        // Todo esto, es para sacar un triste menu
        table.put( "MenuBarUI", "com.nilo.plaf.nimrod.NimRODMenuBarUI");
        table.put( "MenuUI", "com.nilo.plaf.nimrod.NimRODMenuUI");
        table.put( "SeparatorUI", "com.nilo.plaf.nimrod.NimRODSeparatorUI");
        table.put( "PopupMenuUI", "com.nilo.plaf.nimrod.NimRODPopupMenuUI");
        table.put( "PopupMenuSeparatorUI", "com.nilo.plaf.nimrod.NimRODPopupMenuSeparatorUI");
        table.put( "MenuItemUI", "com.nilo.plaf.nimrod.NimRODMenuItemUI");
        table.put( "CheckBoxMenuItemUI", "com.nilo.plaf.nimrod.NimRODCheckBoxMenuItemUI");
        table.put( "RadioButtonMenuItemUI", "com.nilo.plaf.nimrod.NimRODRadioButtonMenuItemUI");
        */   
        /*
        for( Enumeration en = table.keys(); en.hasMoreElements(); ) {
            System.out.println( "[" + en.nextElement() + "]");
        }
        */
    }
    
    @Override
    protected void initComponentDefaults( UIDefaults table) {
        super.initComponentDefaults( table);
        
        //table.put( "Tree.collapsedIcon", new SwingLazyValue( "org.jme3.netbeans.plaf.darkmonkey.DarkMonkeyIconFactory","getTreeCollapsedIcon"));
        table.put("Tree.collapsedIcon", DarkMonkeyIconFactory.getTreeCollapsedIcon());
        table.put("Tree.expandedIcon", DarkMonkeyIconFactory.getTreeExpandedIcon());
        //table.put("Tree.DMCollapsedTreeIcon", Toolkit.getDefaultToolkit().createImage("icons/CollapsedTreeIcon.png"));

//<editor-fold defaultstate="collapsed" desc="lot of Overwrites">
        /* and here are the listings of icons and colors
        try {
        ColorUIResource cFore = (ColorUIResource)table.get( "MenuItem.disabledForeground");
        ColorUIResource cBack = (ColorUIResource)table.get( "MenuItem.foreground");
        
        ColorUIResource col = NimRODUtils.getColorTercio( cBack, cFore);
        table.put(  "MenuItem.disabledForeground", col);
        table.put(  "Label.disabledForeground", col);
        table.put(  "CheckBoxMenuItem.disabledForeground", col);
        table.put(  "Menu.disabledForeground", col);
        table.put(  "RadioButtonMenuItem.disabledForeground", col);
        table.put(  "ComboBox.disabledForeground", col);
        table.put(  "Button.disabledText", col);
        table.put(  "ToggleButton.disabledText", col);
        table.put(  "CheckBox.disabledText", col);
        table.put(  "RadioButton.disabledText", col);
        
        ColorUIResource col2 = NimRODUtils.getColorTercio( NimRODLookAndFeel.getWhite(),
        (Color)table.get( "TextField.inactiveBackground"));
        table.put( "TextField.inactiveBackground", col2);
        }
        catch ( Exception ex) {
        ex.printStackTrace();
        }
        
        table.put( "MenuBar.border", NimRODBorders.getMenuBarBorder());
        
        Font fontMenu = ((Font)table.get( "Menu.font")).deriveFont( Font.BOLD);
        //table.put( "Menu.font", fontMenu);
        //table.put( "MenuItem.font", fontMenu);
        //table.put( "PopupMenu.font", fontMenu);
        //table.put( "RadioButtonMenuItem.font", fontMenu);
        //table.put( "CheckBoxMenuItem.font", fontMenu);
        table.put( "MenuItem.acceleratorFont", fontMenu);
        table.put( "RadioButtonMenuItem.acceleratorFont", fontMenu);
        table.put( "CheckBoxMenuItem.acceleratorFont", fontMenu);
        
        ColorUIResource colAcce = NimRODUtils.getColorTercio( (ColorUIResource)table.get( "MenuItem.foreground"),
        (ColorUIResource)table.get( "MenuItem.acceleratorForeground")
        );
        
        table.put( "MenuItem.acceleratorForeground", colAcce);
        table.put( "RadioButtonMenuItem.acceleratorForeground", colAcce);
        table.put( "CheckBoxMenuItem.acceleratorForeground", colAcce);
        
        // Para la sombra de los popupmenus
        table.put( "BorderPopupMenu.SombraBajIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/SombraMenuBajo.png"));
        table.put( "BorderPopupMenu.SombraDerIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/SombraMenuDer.png"));
        table.put( "BorderPopupMenu.SombraEsqIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/SombraMenuEsq.png"));
        table.put( "BorderPopupMenu.SombraUpIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/SombraMenuUp.png"));
        table.put( "BorderPopupMenu.SombraIzqIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/SombraMenuIzq.png"));
        
        // Para el JTree
        table.put( "Tree.collapsedIcon", NimRODIconFactory.getTreeCollapsedIcon());
        table.put( "Tree.expandedIcon", NimRODIconFactory.getTreeExpandedIcon());
        table.put( "Tree.closedIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/TreeDirCerrado.png"));
        table.put( "Tree.openIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/TreeDirAbierto.png"));
        table.put( "Tree.leafIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/TreeFicheroIcon.png"));
        table.put( "Tree.PelotillaIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/TreePelotilla.png"));
        
        // Los dialogos de ficheros
        table.put( "FileView.directoryIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogDirCerrado.png"));
        table.put( "FileView.fileIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogFicheroIcon.png"));
        table.put( "FileView.floppyDriveIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogFloppyIcon.png"));
        table.put( "FileView.hardDriveIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogHDIcon.png"));
        table.put( "FileChooser.newFolderIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogNewDir.png"));
        table.put( "FileChooser.homeFolderIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogHome.png"));
        table.put( "FileChooser.upFolderIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogDirParriba.png"));
        table.put( "FileChooser.detailsViewIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogDetails.png"));
        table.put( "FileChooser.listViewIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/DialogList.png"));
        
        // Para los muchos CheckBox y RadioButtons
        table.put( "CheckBoxMenuItem.checkIcon", NimRODIconFactory.getCheckBoxMenuItemIcon());
        table.put( "RadioButtonMenuItem.checkIcon", NimRODIconFactory.getRadioButtonMenuItemIcon());
        
        // La flechica de los combos...
        table.put( "ComboBox.flechaIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/ComboButtonDown.png"));
        table.put( "ComboBox.buttonDownIcon", NimRODIconFactory.getComboFlechaIcon());
        
        // Los iconos de los menus
        table.put( "Menu.checkIcon", NimRODIconFactory.getBandaMenuItemIcon());
        table.put( "MenuItem.checkIcon", NimRODIconFactory.getBandaMenuItemIcon());
        table.put( "MenuCheckBox.iconBase", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/MenuCheckBoxBase.png"));
        table.put( "MenuCheckBox.iconTick", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/MenuCheckBoxTick.png"));
        table.put( "MenuRadioButton.iconBase", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/MenuRadioBase.png"));
        table.put( "MenuRadioButton.iconTick", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/MenuRadioTick.png"));
        table.put( "CheckBox.iconBase", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/CheckBoxBase.png"));
        table.put( "CheckBox.iconTick", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/CheckBoxTick.png"));
        table.put( "RadioButton.iconBase", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/RadioButtonBase.png"));
        table.put( "RadioButton.iconTick", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/RadioButtonTick.png"));
        
        // Iconos para los borders generales
        table.put( "BordeGenSup", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenSup.png"));
        table.put( "BordeGenSupDer", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenSupDer.png"));
        table.put( "BordeGenDer", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenDer.png"));
        table.put( "BordeGenInfDer", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenInfDer.png"));
        table.put( "BordeGenInf", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenInf.png"));
        table.put( "BordeGenInfIzq", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenInfIzq.png"));
        table.put( "BordeGenIzq", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenIzq.png"));
        table.put( "BordeGenSupIzq", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/BordeGenSupIzq.png"));
        
        // Bordes generales
        table.put( "List.border", NimRODBorders.getGenBorder());
        table.put( "ScrollPane.viewportBorder", NimRODBorders.getGenBorder());
        table.put( "Menu.border", NimRODBorders.getGenMenuBorder());
        table.put( "ToolBar.border", NimRODBorders.getToolBarBorder());
        table.put( "TextField.border", NimRODBorders.getTextFieldBorder());
        table.put( "TextArea.border", NimRODBorders.getTextFieldBorder());
        table.put( "FormattedTextField.border", NimRODBorders.getTextFieldBorder());
        table.put( "PasswordField.border", NimRODBorders.getTextFieldBorder());
        table.put( "ToolTip.border", NimRODBorders.getToolTipBorder());
        
        table.put( "Table.focusCellHighlightBorder", NimRODBorders.getCellFocusBorder());
        
        // Esto realmente no es necesario porque no se sobrecarga la clase ScrollPaneUI, pero si no se sobrecarga
        // el borde de ScrollPane, NetBeans 5.5 se queda tieso cuando cierras todas las pestañas del panel principal...
        table.put( "ScrollPane.border", NimRODBorders.getScrollPaneBorder());
        
        // Para los ToolTips
        ColorUIResource col2 = NimRODUtils.getColorTercio( NimRODLookAndFeel.getFocusColor(),
        (Color)table.get( "TextField.inactiveBackground"));
        table.put( "ToolTip.background", col2);
        table.put( "ToolTip.font", ((Font)table.get( "Menu.font")));
        
        // Para los Spinners
        table.put( "Spinner.editorBorderPainted", new Boolean( false));
        table.put( "Spinner.border", NimRODBorders.getTextFieldBorder());
        table.put( "Spinner.arrowButtonBorder", BorderFactory.createEmptyBorder());
        table.put( "Spinner.nextIcon", NimRODIconFactory.getSpinnerNextIcon());
        table.put( "Spinner.previousIcon", NimRODIconFactory.getSpinnerPreviousIcon());
        
        // Los iconillos de los dialogos
        table.put( "OptionPane.errorIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/Error.png"));
        table.put( "OptionPane.informationIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/Inform.png"));
        table.put( "OptionPane.warningIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/Warn.png"));
        table.put( "OptionPane.questionIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/Question.png"));
        
        // Para el JSlider
        table.put( "Slider.horizontalThumbIcon", NimRODIconFactory.getSliderHorizontalIcon());
        table.put( "Slider.verticalThumbIcon", NimRODIconFactory.getSliderVerticalIcon());
        table.put( "Slider.horizontalThumbIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/HorizontalThumbIconImage.png"));
        table.put( "Slider.verticalThumbIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/VerticalThumbIconImage.png"));
        
        // Para las scrollbars
        table.put( "ScrollBar.horizontalThumbIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/HorizontalScrollIconImage.png"));
        table.put( "ScrollBar.verticalThumbIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/VerticalScrollIconImage.png"));
        table.put( "ScrollBar.northButtonIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/ScrollBarNorthButtonIconImage.png"));
        table.put( "ScrollBar.southButtonIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/ScrollBarSouthButtonIconImage.png"));
        table.put( "ScrollBar.eastButtonIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/ScrollBarEastButtonIconImage.png"));
        table.put( "ScrollBar.westButtonIconImage", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/ScrollBarWestButtonIconImage.png"));
        table.put( "ScrollBar.northButtonIcon", NimRODIconFactory.getScrollBarNorthButtonIcon());
        table.put( "ScrollBar.southButtonIcon", NimRODIconFactory.getScrollBarSouthButtonIcon());
        table.put( "ScrollBar.eastButtonIcon", NimRODIconFactory.getScrollBarEastButtonIcon());
        table.put( "ScrollBar.westButtonIcon", NimRODIconFactory.getScrollBarWestButtonIcon());
        
        // Margenes de los botones
        table.put( "Button.margin", new InsetsUIResource( 5,14, 5,14));
        table.put( "ToggleButton.margin", new InsetsUIResource( 5,14, 5,14));
        
        // Para los InternalFrames y sus iconillos
        table.put( "Desktop.background", table.get( "MenuItem.background"));
        table.put( "InternalFrame.border", NimRODBorders.getInternalFrameBorder());
        
        table.put( "InternalFrame.NimCloseIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameClose.png"));
        table.put( "InternalFrame.NimCloseIconRoll", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameCloseRoll.png"));
        table.put( "InternalFrame.NimCloseIconPush", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameClosePush.png"));
        
        table.put( "InternalFrame.NimMaxIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameMaximiza.png"));
        table.put( "InternalFrame.NimMaxIconRoll", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameMaximizaRoll.png"));
        table.put( "InternalFrame.NimMaxIconPush", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameMaximizaPush.png"));
        
        table.put( "InternalFrame.NimMinIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameMinimiza.png"));
        table.put( "InternalFrame.NimMinIconRoll", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameMinimizaRoll.png"));
        table.put( "InternalFrame.NimMinIconPush", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameMinimizaPush.png"));
        
        table.put( "InternalFrame.NimResizeIcon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameResize.png"));
        table.put( "InternalFrame.NimResizeIconRoll", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameResizeRoll.png"));
        table.put( "InternalFrame.NimResizeIconPush", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/FrameResizePush.png"));
        
        table.put( "InternalFrame.closeIcon", NimRODIconFactory.getFrameCloseIcon());
        table.put( "InternalFrame.minimizeIcon", NimRODIconFactory.getFrameAltMaximizeIcon());
        table.put( "InternalFrame.maximizeIcon", NimRODIconFactory.getFrameMaxIcon());
        table.put( "InternalFrame.iconifyIcon", NimRODIconFactory.getFrameMinIcon());
        table.put( "InternalFrame.icon", NimRODUtils.loadRes( "/com/nilo/plaf/nimrod/icons/Frame.png"));
        table.put( "NimRODInternalFrameIconLit.width", new Integer( 20));
        table.put( "NimRODInternalFrameIconLit.height", new Integer( 20));
        
        Font fontIcon = ((Font)table.get( "InternalFrame.titleFont")).deriveFont( Font.BOLD);
        table.put( "DesktopIcon.font", fontIcon);
        table.put( "NimRODDesktopIcon.width", new Integer( 80));
        table.put( "NimRODDesktopIcon.height", new Integer( 60));
        table.put( "NimRODDesktopIconBig.width", new Integer( 48));
        table.put( "NimRODDesktopIconBig.height", new Integer( 48));
        
        // Esto no se usa dentro del codigo de NimROD LaF, pero SWTSwing y el plugin EoS de Eclipse si lo usan
        table.put( "InternalFrame.activeTitleBackground", getMenuSelectedBackground());
        table.put( "InternalFrame.activeTitleGradient", getMenuSelectedBackground().darker());
        table.put( "InternalFrame.inactiveTitleBackground", getMenuBackground().brighter());
        table.put( "InternalFrame.inactiveTitleGradient", getMenuBackground().darker());*/
        //Esto es solo para saber que hay en la tabla
        /*
        for( Enumeration en = table.keys(); en.hasMoreElements(); ) {
        System.out.println( "[" + en.nextElement() + "]");
        }
        */
//</editor-fold>
    }

}
