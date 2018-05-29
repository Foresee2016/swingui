package org.foresee.swingui.layout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * BoxLayout 若干组件按水平或垂直方向依次排列。Swing提供了Box容器组件，快速创建箱式布局。 
 * Box内的组件之间默认没有空隙，可以创建glue、struts、rigidAreas三种不可见的组件占位，填充空隙。
 * Box类提供了静态方法辅助。
 */
public class DemoBoxLayout {
	public static void main(String[] args) {
		JFrame frame=new JFrame("BoxLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Box hBox1=Box.createHorizontalBox();
		hBox1.add(new JButton("Button 1"));
		hBox1.add(Box.createHorizontalStrut(5));
		hBox1.add(new JButton("Button 2"));
		hBox1.add(new JButton("Button 3"));
		
		Box hBox2=Box.createHorizontalBox();
		hBox2.add(new JButton("Button 4"));
		hBox2.add(Box.createHorizontalGlue());
		hBox2.add(new JButton("Button 5"));
		
		Box vBox=Box.createVerticalBox();
		vBox.add(hBox1);
		vBox.add(Box.createVerticalStrut(10));
		vBox.add(hBox2);
		
		frame.setContentPane(vBox);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
