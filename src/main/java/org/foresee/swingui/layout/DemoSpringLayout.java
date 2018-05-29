package org.foresee.swingui.layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/**
 * SpringLayout, 弹性布局管理器，容器内每个组件对应着一个约束，该约束定义组件或容器四条边的坐标位置。
 * SpringLayout.Constraints对应约束，Spring对应坐标距离，Spring有静态方法帮助计算距离
 */
public class DemoSpringLayout {
	public static void main(String[] args) {
		JFrame frame=new JFrame("SpringLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		
		SpringLayout layout=new SpringLayout();
		JPanel panel=new JPanel(layout);
		frame.setContentPane(panel);
		
		JLabel label=new JLabel("Test JLabel");
		JButton button=new JButton("Btn");
		JTextField textField=new JTextField("Text Field");
		
		panel.add(label);
		panel.add(button);
		panel.add(textField);
		
		// 组件约束设置，弹性布局设置的关键
		// 标签组件，设置左上角坐标55
		SpringLayout.Constraints labelCons=layout.getConstraints(label); // 获取组件的约束对象（如果没有，会自动创建）
		labelCons.setX(Spring.constant(5));
		labelCons.setY(Spring.constant(5));
		
		// 按钮组件，设置左上角水平坐标5，垂直坐标为标签的南边坐标。设置东边坐标为标签的东边坐标
		SpringLayout.Constraints btnCons=layout.getConstraints(button); // 获取组件的约束对象（如果没有，会自动创建）
		btnCons.setX(Spring.constant(5));
		btnCons.setY(labelCons.getConstraint(SpringLayout.SOUTH));
		btnCons.setConstraint(SpringLayout.EAST, labelCons.getConstraint(SpringLayout.EAST));
		
		// 文本框约束，左上角坐标水平坐标为标签东边坐标+5，垂直坐标为5
		SpringLayout.Constraints textFieldCons=layout.getConstraints(textField); // 获取组件的约束对象（如果没有，会自动创建）
		textFieldCons.setX(Spring.sum(labelCons.getConstraint(SpringLayout.EAST), Spring.constant(5)));
		textFieldCons.setY(Spring.constant(5));
		
		// 内容面板容器的约束设置，确定组件和容器的右边和底边之间的间隙大小
		SpringLayout.Constraints panelCons=layout.getConstraints(panel);
		// 容器东边坐标为文本框东边坐标+5
		panelCons.setConstraint(SpringLayout.EAST, Spring.sum(textFieldCons.getConstraint(SpringLayout.EAST), Spring.constant(5)));
		// 计算按钮和文本框南边坐标的较大者，设置容器南边坐标为最大南边坐标+5
		Spring maxHeightSpring=Spring.max(btnCons.getConstraint(SpringLayout.SOUTH), textFieldCons.getConstraint(SpringLayout.SOUTH));
		panelCons.setConstraint(SpringLayout.SOUTH, Spring.sum(maxHeightSpring, Spring.constant(5)));
		
		frame.setVisible(true);
	}
}
