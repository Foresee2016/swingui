package org.foresee.swingui.table;

import java.awt.BorderLayout;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * JTable 还支持单击表头按该列进行升序或降序的排序，只需要给表格设置一个表格行排序器TableRowSorter（按字典顺序排序）。
 * 自定义排序器MyTableRowSorter，当排序列是数值列时，按数值大小排序。
 */
public class DemoTableRowSorter {
	public static void main(String[] args) {
		JFrame frame = new JFrame("JTable-单击标题栏排序");
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
		 // 使用 表格模型 创建 行排序器（TableRowSorter 实现了 RowSorter）
        RowSorter<TableModel> rowSorter = new MyTableRowSorter(table.getModel());
        table.setRowSorter(rowSorter);
        
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	public static class MyTableRowSorter extends TableRowSorter<TableModel> {
		public MyTableRowSorter(TableModel tableModel) {
			super(tableModel);
		}
		@Override
		public Comparator<?> getComparator(int column) {
			if(column>=1 && column <= 4){ // 数值的4列使用数值比较器，其它的传给父类，用默认的
				return new Comparator<String>() { //NOTE：泛型不能直接Integer，无法强制转换
					@Override
					public int compare(String o1, String o2) {
						return Integer.parseInt(o1) - Integer.parseInt(o2);
					}
				};
			}
			return super.getComparator(column);
		}
	}
}
