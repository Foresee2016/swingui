package org.foresee.swingui.lookfeel;

import com.alee.laf.WebLookAndFeel;

public class DemoWebLaF {
	public static void main(String[] args) {
		// 第三方LookAndFeel：WebLaF，中文字符显示有问题
		// Install WebLaF as application L&F
		WebLookAndFeel.install();

		// You can also do that with one of old-fashioned ways:
		// UIManager.setLookAndFeel ( new WebLookAndFeel () );
		// UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
		// UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName ()
		// );

		// Create you application here using Swing components
		// JFrame frame = ...

		// Or use similar Web* components to get access to some extended
		// features
		// WebFrame frame = ...

		new DemoJFrame();
	}
}
