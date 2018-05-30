package org.foresee.swingui.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

/**
 * TableCellEditor编辑器是用于编辑单元格数据时显示(使用)的组件。
 * 使用编辑器，可控制单元格内输入的内容格式，监听输入的内容变化等。
 * 常用的编辑组件为 JTextField(文本框)，也可使用 JCheckBox(复选框)、JComboBox(文本框) 等组件作为编辑组件。
 * 编辑器接口为TableCellEditor，只有一个方法，即为指定的单元格提供一个编辑组件。
 * 实际使用时通常使用已实现了该接口的默认编辑器DefaultCellEditor。
 */
public class DemoTableCellEditor {
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
		// @formatter:on
		// 这种构造方式下，JTable提供TableModel的实现，并提供修改、更新UI等功能
		JTable table = new JTable(rowData, colNames);
		MyTableCellEditor cellEditor=new MyTableCellEditor(new JTextField());
		for (int i = 1; i < colNames.length; i++) { //遍历所有数字列，设置单元格编辑器
			TableColumn col=table.getColumn(colNames[i]);
			col.setCellEditor(cellEditor);
		}
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	public static class MyTableCellEditor extends DefaultCellEditor{
		private static final long serialVersionUID = 4833190427852738716L;

		public MyTableCellEditor(JCheckBox checkBox) {
			super(checkBox);
		}
		public MyTableCellEditor(JTextField textField) {
			super(textField);
		}
		public MyTableCellEditor(JComboBox<?> comboBox) {
			super(comboBox);
		}
		@Override
		public boolean stopCellEditing() {
			Component component=getComponent(); //获取当前单元格编辑器组件
			Object object=getCellEditorValue(); //获取当前单元格编辑器输入值
			if(object==null || !object.toString().matches("[0-9]*")){ //不是数字，标志错误，返回false（不允许保存）
				component.setForeground(Color.red);
				return false;
			}
			component.setForeground(Color.BLACK);
			return super.stopCellEditing(); //合法数据交给父类处理
		}
	}
}
