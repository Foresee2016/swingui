package org.foresee.swingui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.foresee.swingui.dialog.MainFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
    		//Nimbus水晶风格，默认的是Metal风格
			UIManager.setLookAndFeel(new NimbusLookAndFeel()); 
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
        new MainFrame();
    }
}
