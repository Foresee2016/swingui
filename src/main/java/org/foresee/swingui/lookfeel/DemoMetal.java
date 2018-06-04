package org.foresee.swingui.lookfeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class DemoMetal {
	public static void main(String[] args) {
		// 默认的LookAndFeel就是Metal
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel()); 
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	    new DemoJFrame();
	}
}
