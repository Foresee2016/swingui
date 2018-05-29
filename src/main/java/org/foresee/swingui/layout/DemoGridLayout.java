package org.foresee.swingui.layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GridLayout 以网格划分容器成为大小相等的矩形网格，一个网格中放入一个组件，组件宽高自动撑满网格。
 * 以行数和总数优先，假如指定了3行2列，添加了9个组件，那么会是3行3列，只有行数指定为0时，列生效。
 */
public class DemoGridLayout {

	public static void main(String[] args) {
		JFrame frame = new JFrame("GridLayout");
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(3, 2, 10, 5));
		panel.add(new JButton("Button 1"));
		panel.add(new JButton("Button 2"));
		panel.add(new JButton("Button 3"));
		panel.add(new JButton("Button 4"));
		panel.add(new JButton("Button 5"));
		panel.add(new JButton("Button 6"));
		panel.add(new JButton("Button 7"));
		panel.add(new JButton("Button 8"));
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

}
