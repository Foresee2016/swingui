package org.foresee.swingui.lookfeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class DemoNimbus {
	public static void main(String[] args) {
		try {
			//Nimbus水晶风格，默认的是Metal风格
			UIManager.setLookAndFeel(new NimbusLookAndFeel()); 
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	    new DemoJFrame();
	}
}
