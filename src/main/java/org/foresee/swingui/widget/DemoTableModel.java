package org.foresee.swingui.widget;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * TableModel是个接口，指定JTable的数据模型，它的实现中封装各种数据。JTable构造函数里直接传入数据时，自动封装了TableModel
 * 已有的实现：
 * AbstractTableModel实现了大部分默认方法，留下三个未实现的方法。它的isCellEditable()返回了false，默认单元格不可编辑
 * DefaultTableModel，一个完整实现，使用Vector存储值对象，该Vector内部也是Vector，并且增加了添加删除行列等辅助操作
 */
public class DemoTableModel {
	public static void main(String[] args) {
		JFrame frame=new JFrame("JTable-MyTableModel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel(new BorderLayout());
		JTable table=new JTable(new MyTableModel());
		panel.add(table.getTableHeader(), BorderLayout.NORTH);// 添加标题行
		panel.add(table, BorderLayout.CENTER);// 添加内容行
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static class MyTableModel extends AbstractTableModel{
		private static final long serialVersionUID = 6908144420113628914L;
		private Object[] colNames={"姓名","语文","数学","英语","总分"};
		private Object[][] rowData={
				{"Antenna", 80, 80, 80, 240},
				{"Buffalo", 70, 80, 90, 240},
				{"Cheese", 90, 95, 100, 285},
				{"Dragon", 80, 70, 60, 210},
				{"Effort", 90, 70, 60, 220},
				{"Foresee", 100, 90, 90, 280},
		};
		@Override
		public int getColumnCount() {
			return colNames.length;
		}

		@Override
		public int getRowCount() {
			return rowData.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return rowData[rowIndex][columnIndex];
		}
		// AbstractTableModel 默认回false，不可编辑，重写它，除了姓名列其它可编辑
		// 但是修改不会生效，因为数据模型没有变，需要监听表格数据改变事件。
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if(columnIndex>=1){
				return true;
			}
			return false;
		}
	}
}
