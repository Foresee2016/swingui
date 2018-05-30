package org.foresee.swingui.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class DemoTableCellRenderer {
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
		MyTableCellRenderer renderer=new MyTableCellRenderer();
		for (int i = 0; i < colNames.length; i++) { // 遍历表格的每一列，分别给每一列设置单元格渲染器
			TableColumn tableColumn=table.getColumn(colNames[i]);
			tableColumn.setCellRenderer(renderer);
		}
		// 如果需要自定义表头样式，也可以给表头设置一个自定义渲染器
        // table.getTableHeader().setDefaultRenderer(headerRenderer);
		
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	public static class MyTableCellRenderer extends DefaultTableCellRenderer{
		private static final long serialVersionUID = 5455545421010177391L;
		@Override
		// 返回默认的表单元格渲染器，此方法在父类中已实现，直接调用父类方法返回，在返回前做相关参数的设置即可
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if(row%2==0){ //背景斑马条纹
				setBackground(Color.white);
			}else {
				setBackground(Color.lightGray);
			}
			if(column==0){ // 第一列居中，最后一列居右，其它居左
				setHorizontalAlignment(SwingConstants.CENTER);
			}else if (column==(table.getColumnCount() - 1)) {
				setHorizontalAlignment(SwingConstants.RIGHT);
			}else {
				setHorizontalAlignment(SwingConstants.LEFT);
			}
			// 设置提示文本，当鼠标移动到当前（row，column）所在单元格时提示文本
			setToolTipText("提示文本："+row+", "+column);
			// NOTE: 多个单元格使用同一渲染器时，需要自定义的属性，必须每次都设置，否则将自动沿用上一次的设置。
			
			/*
             * 单元格渲染器为表格单元格提供具体的显示，实现了单元格渲染器的 DefaultTableCellRenderer 继承自
             * 一个标准的组件类 JLabel，因此 JLabel 中相应的 API 在该渲染器实现类中都可以使用。
             *
             * super.getTableCellRendererComponent(...) 返回的实际上是当前对象（this），即 JLabel 实例，
             * 也就是以 JLabel 的形式显示单元格。
             *
             * 如果需要自定义单元格的显示形式（比如显示成按钮、复选框、内嵌表格等），可以在此自己创建一个标准组件
             * 实例返回。
             */
			
			// 调用父类的该方法完成渲染器的其他设置
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	}
}
