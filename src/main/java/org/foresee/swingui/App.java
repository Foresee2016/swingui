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
			UIManager.setLookAndFeel(new NimbusLookAndFeel()); //Nimbus水晶风格
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
        new MainFrame();
    }
}
