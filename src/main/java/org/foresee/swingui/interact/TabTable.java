package org.foresee.swingui.interact;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * 学习把JTable放在JTabbedPane中，添加JScrollPane，应对生成多张表，且表数据较多的情况。
 */
public class TabTable extends JFrame {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			System.err.println("无法使用Nimbus观感，将使用默认Metal观感");
		}
		new TabTable();
	}

	private static final long serialVersionUID = 3789178965100904678L;
	public static String[] colNames = { "参数", "当前值" };
	DefaultTableModel tableModel;
	ArrayList<JTable> tables;
	ArrayList<Info> infos;
	JTable table;
	TableModelListener modelListener;
	JTabbedPane tabPane;
	JButton addBtn;
	JButton delBtn;
	JButton outputBtn;
	int tabCnt = 0;

	public TabTable() {
		initModel();
		initView();
		initController();
		setTitle("动态多表格");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void initModel() {
		tables = new ArrayList<>();
		infos = new ArrayList<>();
	}

	private void initView() {
		setLayout(new BorderLayout());
		tabPane = new JTabbedPane();
		tabPane.setPreferredSize(new Dimension(200, 400));
		tabPane.setBorder(createBorder10());
		add(tabPane, BorderLayout.CENTER);

		addBtn = new JButton("添加表格");
		addBtn.setPreferredSize(new Dimension(150, 40));
		delBtn = new JButton("删除表格");
		delBtn.setPreferredSize(new Dimension(150, 40));
		outputBtn = new JButton("输出各表格参数");
		outputBtn.setPreferredSize(new Dimension(180, 40));
		Box hBox = Box.createHorizontalBox();
		hBox.add(addBtn);
		hBox.add(delBtn);
		hBox.add(outputBtn);
		hBox.setBorder(createBorder10());
		add(hBox, BorderLayout.SOUTH);
		pack();
	}

	private void initController() {
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				addTable();
			}
		});
		delBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int curTab = tabPane.getSelectedIndex();
				if (curTab >= 0) {
					tables.remove(curTab);
					infos.remove(curTab);
					tabPane.remove(curTab);
				} else {
					System.out.println("暂时没有表格，不能删除");
				}
			}
		});
		outputBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				for (Info info : infos) {
					System.out.println(info);
				}
			}
		});
		modelListener = new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int type = e.getType();
				if (type == TableModelEvent.UPDATE) {
					tableDataToInfo();
				}
			}
		};
	}

	protected void tableDataToInfo() {
		int curTab = tabPane.getSelectedIndex();
		DefaultTableModel tableModel = (DefaultTableModel) tables.get(curTab).getModel();
		Info info = infos.get(curTab);
		info.str = tableModel.getValueAt(0, 1).toString();
		try {
			info.value1 = Integer.parseInt(tableModel.getValueAt(1, 1).toString());
			info.value2 = Integer.parseInt(tableModel.getValueAt(2, 1).toString());
			info.value3 = Integer.parseInt(tableModel.getValueAt(3, 1).toString());
			info.value4 = Integer.parseInt(tableModel.getValueAt(4, 1).toString());
			info.value5 = Integer.parseInt(tableModel.getValueAt(5, 1).toString());
			info.value6 = Integer.parseInt(tableModel.getValueAt(6, 1).toString());
			info.value7 = Integer.parseInt(tableModel.getValueAt(7, 1).toString());
			info.value8 = Integer.parseInt(tableModel.getValueAt(8, 1).toString());
			info.value9 = Integer.parseInt(tableModel.getValueAt(9, 1).toString());
			info.value10 = Integer.parseInt(tableModel.getValueAt(10, 1).toString());
			info.value11 = Double.parseDouble(tableModel.getValueAt(11, 1).toString());
			info.value12 = Double.parseDouble(tableModel.getValueAt(12, 1).toString());
			info.value13 = Double.parseDouble(tableModel.getValueAt(13, 1).toString());
			info.value14 = Double.parseDouble(tableModel.getValueAt(14, 1).toString());
			info.value15 = Double.parseDouble(tableModel.getValueAt(15, 1).toString());
		} catch (NumberFormatException e) {
			System.out.println("输入到表格中的值不能转换为数字");
			System.out.println(e.getMessage());
		}
	}

	protected void addTable() {
		tableModel = new DefaultTableModel(colNames, 16); // Info对象属性数量16个
		Info info = randomInfo();
		infos.add(info);
		setCol1(tableModel);
		setCol2(tableModel, info);
		table = new JTable(tableModel);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("", Font.BOLD, 16));
		table.setFont(new Font("", Font.PLAIN, 14));
		table.setPreferredSize(new Dimension(180, 300));
		tables.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		tabPane.addTab("参数表" + tabCnt, scrollPane);
		tabCnt++;
		tabPane.setSelectedIndex(tables.size() - 1);
		tableModel.addTableModelListener(modelListener); // 监听表格改变，反映到Info记录中
	}

	protected void setCol2(DefaultTableModel tableModel, Info info) {
		tableModel.setValueAt(info.str, 0, 1);
		tableModel.setValueAt(info.value1, 1, 1);
		tableModel.setValueAt(info.value2, 2, 1);
		tableModel.setValueAt(info.value3, 3, 1);
		tableModel.setValueAt(info.value4, 4, 1);
		tableModel.setValueAt(info.value5, 5, 1);
		tableModel.setValueAt(info.value6, 6, 1);
		tableModel.setValueAt(info.value7, 7, 1);
		tableModel.setValueAt(info.value8, 8, 1);
		tableModel.setValueAt(info.value9, 9, 1);
		tableModel.setValueAt(info.value10, 10, 1);
		tableModel.setValueAt(info.value11, 11, 1);
		tableModel.setValueAt(info.value12, 12, 1);
		tableModel.setValueAt(info.value13, 13, 1);
		tableModel.setValueAt(info.value14, 14, 1);
		tableModel.setValueAt(info.value15, 15, 1);
	}

	/**
	 * 初始化第一列的名称
	 */
	protected void setCol1(DefaultTableModel tableModel) {
		tableModel.setValueAt("str", 0, 0);
		tableModel.setValueAt("value1", 1, 0);
		tableModel.setValueAt("value2", 2, 0);
		tableModel.setValueAt("value3", 3, 0);
		tableModel.setValueAt("value4", 4, 0);
		tableModel.setValueAt("value5", 5, 0);
		tableModel.setValueAt("value6", 6, 0);
		tableModel.setValueAt("value7", 7, 0);
		tableModel.setValueAt("value8", 8, 0);
		tableModel.setValueAt("value9", 9, 0);
		tableModel.setValueAt("value10", 10, 0);
		tableModel.setValueAt("value11", 11, 0);
		tableModel.setValueAt("value12", 12, 0);
		tableModel.setValueAt("value13", 13, 0);
		tableModel.setValueAt("value14", 14, 0);
		tableModel.setValueAt("value15", 15, 0);
	}

	private Border createBorder10() {
		return BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createRaisedBevelBorder());
	}

	protected Info randomInfo() {
		Info info = new Info();
		info.str = "时间戳" + System.currentTimeMillis();
		info.value1 = (int) (Math.random() * 100);
		info.value2 = (int) (Math.random() * 100);
		info.value3 = (int) (Math.random() * 100);
		info.value4 = (int) (Math.random() * 100);
		info.value5 = (int) (Math.random() * 100);
		info.value6 = (int) (Math.random() * 100);
		info.value7 = (int) (Math.random() * 100);
		info.value8 = (int) (Math.random() * 100);
		info.value9 = (int) (Math.random() * 100);
		info.value10 = (int) (Math.random() * 100);
		info.value11 = Math.round(Math.random() * 10000) / 100; // 四舍五入保留两位小数
		info.value12 = Math.round(Math.random() * 10000) / 100;
		info.value13 = Math.round(Math.random() * 10000) / 100;
		info.value14 = Math.round(Math.random() * 10000) / 100;
		info.value15 = Math.round(Math.random() * 10000) / 100;
		return info;
	}

	public class Info {
		public String str;
		public int value1;
		public int value2;
		public int value3;
		public int value4;
		public int value5;
		public int value6;
		public int value7;
		public int value8;
		public int value9;
		public int value10;
		public double value11;
		public double value12;
		public double value13;
		public double value14;
		public double value15;

		@Override
		public String toString() {
			return str + ", " + value1 + ", " + value2 + ", " + value3 + ", " + value11 + ", " + value12 + ", "
					+ value13;
		}
	}
}
