package org.foresee.swingui.widget;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DemoRadioButton {
	public static void main(String[] args) {
		JFrame frame=new JFrame("单选按钮");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		JRadioButton radioButton1=new JRadioButton("男");
		JRadioButton radioButton2=new JRadioButton("女");
		
		ButtonGroup buttonGroup=new ButtonGroup(); //单选框添加到组里，一组就一个选中
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		radioButton1.setSelected(true);
		
		panel.add(radioButton1);
		panel.add(radioButton2);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}
