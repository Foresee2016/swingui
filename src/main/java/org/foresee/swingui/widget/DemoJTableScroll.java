package org.foresee.swingui.widget;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class DemoJTableScroll {
	public static void main(String[] args) {
		JFrame frame=new JFrame("JTable");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				{"Grit", 80, 90, 90, 260},
				{"Honey", 90, 90, 90, 270},
				{"Immortal", 80, 90, 90, 260},
				{"Jell-O", 80, 90, 90, 260},
				{"Knight", 80, 80, 90, 240},
		};
		JTable table=new JTable(rowData, colNames);
		/*
		 * NOTE：如果JTable添加到JScrollPane容器中， 标题会固定，内容滚动
		 */
		JScrollPane scrollPane=new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.setContentPane(scrollPane);
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
