package org.foresee.swingui.widget;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class DemoTableModelListener {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JTable-TableModelListener");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		// 表头（列名称）
		Object[] colNames = { "姓名", "语文", "数学", "英语", "总分" };
		// 内容数据
		// @formatter:off
		Object[][] rowData = { 
				{ "Antenna", 80, 80, 80, 240 }, 
				{ "Buffalo", 70, 80, 90, 240 },
				{ "Cheese", 90, 95, 100, 285 }, 
				{ "Dragon", 80, 70, 60, 210 }, 
				{ "Effort", 90, 70, 60, 220 },
				{ "Foresee", 100, 90, 90, 280 }, 
		};
		// @formatter:on
		JTable table = new JTable(new AbstractTableModel() {
			private static final long serialVersionUID = 1573971095401283931L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return rowData[rowIndex][columnIndex];
			}
			
			@Override
			public int getRowCount() {
				return rowData.length;
			}
			
			@Override
			public int getColumnCount() {
				return colNames.length;
			}
			@Override
			public String getColumnName(int column) {
				return colNames[column].toString();
			}
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return columnIndex != 4; //总分列不可编辑，由加和求出
			}
			@Override
			public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
				// 设置新的单元格数据时，必须把新值设置到原数据数值中，
                // 待更新UI重新调用 getValueAt(...) 获取单元格值时才能获取到最新值
                rowData[rowIndex][columnIndex] = newValue;
                // 设置完数据后，必须通知表格去更新UI（重绘单元格），否则显示的数据不会改变
                fireTableCellUpdated(rowIndex, columnIndex);
			}
		});
		/*
         * 上面的继承 AbstractTableModel 实现自定义表格模型，功能并不完整，还有很多需要自己
         * 去实现（例如更新数据，通知UI更新，列名称获取等），建议使用 DefaultTableModel 类，
         * 该类对 TableModel 做了较为完善的实现，支持自动更新数据处理，支持UI自动更新，列名称
         * 处理，添加/移除行列等。无特殊要求不需要重写方法，直接使用即可，如下两行代码即可:
         */
        // DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
        // JTable table = new JTable(tableModel);
		
		// 为表格模型添加数据改变监听器，改变三科分数时，自动求和更新总分
		final TableModel tableModel=table.getModel();
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// 获取 第一个 和 最后一个 被改变的行（只改变了一行，则两者相同）
				int firstRow=e.getFirstRow();
				int lastRow=e.getLastRow();
				int column=e.getColumn(); //被改变的列
				/* 事件的类型，可能的值有:
                 * TableModelEvent.INSERT   新行或新列的添加
                 * TableModelEvent.UPDATE   现有数据的更改
                 * TableModelEvent.DELETE   有行或列被移除
                 */
				int type=e.getType();
				if(type==TableModelEvent.UPDATE){
					if(column<1 || column>3){ //处理三科成绩的三列，其它不处理
						return;
					}
					for (int row = firstRow; row <= lastRow; row++) {
						try {
							int chinese=Integer.parseInt(tableModel.getValueAt(row, 1).toString());
							int math=Integer.parseInt(tableModel.getValueAt(row, 2).toString());
							int english=Integer.parseInt(tableModel.getValueAt(row, 3).toString());
							int total=chinese+math+english;
							tableModel.setValueAt(total, row, 4);
						} catch (NumberFormatException e2) {
							e2.printStackTrace();
							return;
						}
					}
				}
			}
		});
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
