package org.foresee.swingui.lookfeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

@SuppressWarnings("restriction")
public class DemoWindows {
	public static void main(String[] args) {
		// Windows风格，仅限Windows平台使用
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new DemoJFrame();
	}
}
