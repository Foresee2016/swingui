package org.foresee.swingui.pane;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

/**
 * JSplitPane 分隔面板，用于分隔两个（只能两个）组件，
 * 两个组件通过水平或垂直分隔条分别左右或上下显示，可以拖动分隔条调整显示区域大小 
 */
public class DemoJSplitPane {
	public static void main(String[] args) {
		JFrame frame=new JFrame("分隔面板");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JSplitPane splitPane=new JSplitPane();
		splitPane.setLeftComponent(new JButton("左边按钮"));
		splitPane.setRightComponent(new JButton("右边按钮"));
		// 设置 折叠/展开 按钮
		splitPane.setOneTouchExpandable(true);
		// 在拖动分隔条时连续重绘
		splitPane.setContinuousLayout(true);
		// 设置分隔条位置
		splitPane.setDividerLocation(150);
		frame.setContentPane(splitPane);
		frame.setVisible(true);
	}
}
