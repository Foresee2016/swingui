package org.foresee.swingui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

/**
 * Border，边框。边框是对组件边界的装饰，例如为组件增加矩形有色边框，为透明的容器增加带标题的边框，
 * 增加组件的内边距，为组件增加浮雕化/凹凸斜面/阴影外观等，让组件看起来更美观。 BorderFactory的静态方法辅助。
 * 空边框、线边框、标题边框、和各种特效边框
 */
public class DemoBorder {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Border");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JPanel panel1 = createPanel();
		panel1.setBorder(BorderFactory.createLineBorder(Color.red));
		JPanel panel2 = createPanel();
		panel2.setBorder(BorderFactory.createTitledBorder("标题边框"));
		JPanel panel3 = createPanel();
		panel3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		JPanel panel4 = createPanel();
		panel4.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10),
				BorderFactory.createLoweredBevelBorder())); //可以复合边框，外层留margin-10px，内层内嵌

		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	private static JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(180, 180));
		panel.add(new JLabel("Label"));
		panel.add(new JButton("Button"));
		panel.add(new JRadioButton("Radio"));
		panel.add(new JCheckBox("CheckBox"));
		return panel;
	}
}
