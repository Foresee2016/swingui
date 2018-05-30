package org.foresee.swingui.table;

import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 表格数据的选择使用ListSelectionModel选择器模型维护，允许用户以不同的模式选中表格中的数据
 */
public class DemoListSelectionModel {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JTable-ListSelectionModel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		// 表头（列名称）
		Object[] colNames = { "姓名", "语文", "数学", "英语", "总分" };
		// 内容数据
		// @formatter:off
		Object[][] rowData={
				{"Antenna", 80, 80, 80, 240},
				{"Buffalo", 70, 80, 90, 240},
				{"Cheese", 90, 95, 100, 285},
				{"Dragon", 80, 70, 60, 210},
				{"Effort", 90, 70, 60, 220},
				{"Foresee", 100, 90, 90, 280},
		};
		// 这种构造方式下，JTable提供TableModel的实现，并提供修改、更新UI等功能
		JTable table = new JTable(rowData, colNames);
		// 设置是否允许单元格单个选中，默认false
		table.setCellSelectionEnabled(true);
		ListSelectionModel selectionModel = table.getSelectionModel();
		/*
		 * 设置选择器模式，参数可能的值为: 
		 * ListSelectionModel.MULTIPLE_INTERVAL_SELECTION 一次选择一个或多个连续的索引范围（默认）
		 * ListSelectionModel.SINGLE_INTERVAL_SELECTION 一次选择一个连续的索引范围 
		 * ListSelectionModel.SINGLE_SELECTION 一次只能选择一个列表索引
		 */
		selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow=table.getSelectedRow(); //获取选中的第一行
				int selectedCol=table.getSelectedColumn(); //获取选中的第一列
				int[] selectedRows=table.getSelectedRows();
				int[] selectedCols=table.getSelectedColumns();
				System.out.println(selectedRow+", "+selectedCol);
				System.out.println(Arrays.toString(selectedRows));
				System.out.println(Arrays.toString(selectedCols));
			}
		});
		// @formatter:on
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
