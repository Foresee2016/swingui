package org.foresee.swingui.lookfeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;

@SuppressWarnings("restriction")
public class DemoWindowsClassic {
	public static void main(String[] args) {
		// Windows风格，仅限Windows平台使用
		try {
			UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new DemoJFrame();
	}
}
