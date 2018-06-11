package org.foresee.swingui.widget;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DemoJLabel {
	public static void main(String[] args) {
		JFrame frame=new JFrame("JLabel多种使用方法");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel(new GridLayout(5, 1, 10, 10));
		
		JLabel label1=new JLabel("最简单的，单行文本");
		label1.setFont(new Font("", Font.PLAIN, 25));
		panel.add(label1);
		
		JLabel label2=new JLabel("<html>HTML内容<br><small>标签有效<small></html>");
		panel.add(label2);
		
		JLabel label3=new JLabel();
		label3.setIcon(new ImageIcon("mario128.jpg"));
		panel.add(label3);
		
		JLabel label4=new JLabel("文本和图片");
		label4.setIcon(new ImageIcon("mario128.jpg"));
		panel.add(label4);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
