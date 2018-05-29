package org.foresee.swingui.layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GridBagLayout， 不要求组件大小相同，可以将组件垂直、水平或沿基线对齐。
 * 每个对象维持动态矩形单元格（动态计算大小），每个组件占用一个或多个单元格，称为显示区域。每个组件显示区域按左到右，上到下依次排列
 * 每个GridBagLayout关联一个GridBagConstraints实例，以指定组件所在显示区域的具体放置位置，以及组件在显示区域的对齐方式。
 * GridBagConstraints属性指定单元格开始坐标、横纵占单元格数量、额外空间（容器边缘内的间隔，调用pack()后无额外空间）、约束属性（填充，对齐，内外边距）等。
 */
public class DemoGridBagLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GridBagLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		// 添加组件和约束
		GridBagConstraints c=new GridBagConstraints();
		c.insets=new Insets(5, 5, 5, 5);
		panel.add(new JButton("Button 1"), c); //内部使用的是c的副本
		panel.add(new JButton("Button 2"), c);
		panel.add(new JButton("Button 3"), c);
		c=new GridBagConstraints();
		c.gridwidth=GridBagConstraints.REMAINDER; //占所在行或列所有剩余单元格
		c.fill=GridBagConstraints.BOTH; //横向和纵向都拉伸组件，填满显示区域
		panel.add(new JButton("Button 4"), c);
		panel.add(new JButton("Button 5"), c);
		
		c=new GridBagConstraints();
		c.gridwidth=GridBagConstraints.RELATIVE; //占当前行直到行尾的倒数第二个单元格，下一个组件需要手动换行
		c.fill=GridBagConstraints.BOTH;
		panel.add(new JButton("Button 6"), c);
		c=new GridBagConstraints();
		c.gridwidth=GridBagConstraints.REMAINDER; //占完这一行最后那一个单元格，相当于后边换行了
		panel.add(new JButton("Button 7"), c);
		c=new GridBagConstraints();
		c.gridheight=2; //占两行
		c.fill=GridBagConstraints.BOTH;
		panel.add(new JButton("Button 8"), c);
		c=new GridBagConstraints();
		c.gridwidth=GridBagConstraints.REMAINDER;
		c.fill=GridBagConstraints.BOTH;
		panel.add(new JButton("Button 9"), c);
		panel.add(new JButton("Button 10"), c);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
