package org.foresee.swingui.layout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * BorderLayout，容器分为东西南北中五个区域 ，每个区域一个组件
 */
public class DemoBorderLayout {
	public static void main(String[] args) {
		JFrame frame=new JFrame("BorderLayout");
		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel(new BorderLayout(10, 15));
		panel.add(new JButton("Button North"), BorderLayout.NORTH);
		panel.add(new JButton("Button SOUTH"), BorderLayout.SOUTH);
		panel.add(new JButton("Button WEST"), BorderLayout.WEST);
		panel.add(new JButton("Button EAST"), BorderLayout.EAST);
		panel.add(new JButton("Button CENTER"), BorderLayout.CENTER);
		
		frame.setContentPane(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
