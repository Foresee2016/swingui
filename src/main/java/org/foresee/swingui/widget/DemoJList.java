package org.foresee.swingui.widget;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DemoJList {
	public static void main(String[] args) {
		JFrame frame=new JFrame("列表框");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		final JList<String> list=new JList<>();
		list.setPreferredSize(new Dimension(200, 100));
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setListData(new String[]{"香蕉", "西瓜","雪梨","苹果"});
		System.out.println("按住Ctrl键多选");
		System.out.println("按住左键后滑动可调整选中位置");
		list.addListSelectionListener(new ListSelectionListener() { 
			//鼠标按下和抬起都触发事件，但e.getValueIsAdjusting()可判断，按下true，抬起false
			//按住后滑动到另一项会调整位置，再触发事件，也就是可以编程实现滑动多选
			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e.getValueIsAdjusting());
				int[] indices=list.getSelectedIndices();
				ListModel<String> listModel=list.getModel();
				for (int index : indices) {
					System.out.println("选中："+index+" = "+listModel.getElementAt(index));
				}
				System.out.println();
			}
		});
		list.setSelectedIndex(1);
		panel.add(list);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}
