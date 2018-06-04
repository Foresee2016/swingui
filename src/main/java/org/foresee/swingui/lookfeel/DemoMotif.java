package org.foresee.swingui.lookfeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.motif.MotifLookAndFeel;

@SuppressWarnings("restriction")
public class DemoMotif {
	public static void main(String[] args) {
		// Motif风格
		try {
			UIManager.setLookAndFeel(new MotifLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new DemoJFrame();
	}
}
