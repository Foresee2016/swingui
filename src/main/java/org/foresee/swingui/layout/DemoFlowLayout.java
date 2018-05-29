package org.foresee.swingui.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 流布局，先按水平方向（默认左到右）排列，排满后下一行。
 * 同一行的align属性，左、中、右、LEADING（与容器开始边对齐），TRAILING（与容器结束边对齐），后两个用于右到左方向时。
 */
public class DemoFlowLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame("FlowLayout");
		frame.setSize(200, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new JButton("Button 1"));
		panel.add(new JButton("Button 2"));
		panel.add(new JButton("Button 3"));
		panel.add(new JButton("Button 4"));
		panel.add(new JButton("Button 5"));
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}
