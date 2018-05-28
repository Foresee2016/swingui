package org.foresee.swingui.pane;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DemoJScrollPane {

	public static void main(String[] args) {
		JFrame frame = new JFrame("滚动面板");
		frame.setSize(250, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true); // 自动换行
		textArea.setFont(new Font(null, Font.PLAIN, 20));
		// 设置可滚动区域，纵向一直显示滚动条，横向不显示
		JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setWheelScrollingEnabled(true); // 设置是否支持鼠标滚轮操作，默认是true
		frame.setContentPane(scrollPane);
		frame.setVisible(true);
	}

}
