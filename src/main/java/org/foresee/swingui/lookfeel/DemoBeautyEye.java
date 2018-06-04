package org.foresee.swingui.lookfeel;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jb2011.lnf.beautyeye.BeautyEyeLookAndFeelCross;

public class DemoBeautyEye {
	public static void main(String[] args) {
		try {
			// 第三方LookAndFeel：BeautyEyeLookAndFeel
			UIManager.setLookAndFeel(new BeautyEyeLookAndFeelCross());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new DemoJFrame();
	}
}
