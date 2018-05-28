package org.foresee.swingui.pane;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DemoJPanel {
	public static void main(String[] args) {
		JFrame frame=new JFrame("登录");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1=new JPanel(); //使用默认浮动布局
		panel1.add(new JLabel("用户名"));
		panel1.add(new JTextField(10));
		
		JPanel panel2=new JPanel();
		panel2.add(new JLabel("密    码"));
		panel2.add(new JTextField(10));
		
		JPanel panel3=new JPanel(new FlowLayout(FlowLayout.CENTER)); // 使用浮动布局，并且容器内组件居中显示
		panel3.add(new JButton("登录"));
		panel3.add(new JButton("注册"));
		// 垂直盒子容器，串联三个JPanel
		Box vBox=Box.createVerticalBox();
		vBox.add(panel1);
		vBox.add(panel2);
		vBox.add(panel3);
		frame.add(vBox);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
