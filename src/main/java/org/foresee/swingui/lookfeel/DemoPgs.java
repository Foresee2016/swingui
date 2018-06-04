package org.foresee.swingui.lookfeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.pagosoft.plaf.PgsLookAndFeel;

public class DemoPgs {
	public static void main(String[] args) {
		try {
			// 第三方LookAndFeel：PgsLookAndFeel
			UIManager.setLookAndFeel(new PgsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new DemoJFrame();
	}
}
