package org.foresee.swingui.widget;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class DemoJTable {
	public static void main(String[] args) {
		JFrame frame=new JFrame("JTable");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel(new BorderLayout());
		// 表头（列名称）
		Object[] colNames={"姓名","语文","数学","英语","总分"};
		// 内容数据
		Object[][] rowData={
				{"Antenna", 80, 80, 80, 240},
				{"Buffalo", 70, 80, 90, 240},
				{"Cheese", 90, 95, 100, 285},
				{"Dragon", 80, 70, 60, 210},
				{"Effort", 90, 70, 60, 220},
				{"Foresee", 100, 90, 90, 280},
		};
		JTable table=new JTable(rowData, colNames);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		// 下面这一行，将JTable添加到中间容器，只会加入内容，而没有标题行
		panel.add(table, BorderLayout.CENTER);
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
