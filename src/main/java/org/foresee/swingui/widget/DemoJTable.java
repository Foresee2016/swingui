package org.foresee.swingui.widget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

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
		// 修改样式
		table.setForeground(new Color(255, 0, 0));
		table.setSelectionForeground(new Color(0, 0, 255));
		table.setSelectionBackground(new Color(0, 160, 0));
		table.setGridColor(Color.cyan);
		table.setShowVerticalLines(false);
		table.setRowHeight(20);
		/*
		 * 设置当手动改变某列列宽时，其他列的列宽自动调整模式，可选值:
		 *     JTable.AUTO_RESIZE_ALL_COLUMNS 在所有的调整大小操作中，按比例调整所有的列。
		 *     JTable.AUTO_RESIZE_LAST_COLUMN 在所有的调整大小操作中，只对最后一列进行调整。
		 *     JTable.AUTO_RESIZE_NEXT_COLUMN 在 UI 中调整了一个列时，对其下一列进行相反方向的调整。
		 *     JTable.AUTO_RESIZE_OFF 不自动调整列的宽度；使用滚动条。
		 *     JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS 在 UI 调整中，更改后续列以保持总宽度不变；此为默认行为。
		 */
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// 列设置
		TableColumn col=table.getColumnModel().getColumn(1);
		col.setWidth(60);
		col.setMinWidth(40);
		col.sizeWidthToFit();
		col.setResizable(true);
		col.setHeaderValue("新设置名称");
		// 表头样式
		JTableHeader header=table.getTableHeader();
		header.setFont(new Font(null, Font.BOLD, 16));
		header.setResizingAllowed(true); //允许拖动表头调整列宽度
		header.setReorderingAllowed(true); //允许拖动表头调整列顺序
		// 数据操作。注：表格内容用户是可以修改的，不只是程序控制
		int value=(int) table.getModel().getValueAt(3, 3);
		table.getModel().setValueAt(value-30, 3, 3);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		// 下面这一行，将JTable添加到中间容器，只会加入内容，而没有标题行
		panel.add(table, BorderLayout.CENTER);
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
