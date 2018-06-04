package org.foresee.swingui.lookfeel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class DemoJFrame extends JFrame{
	private static final long serialVersionUID = -3704577735216622749L;

	public DemoJFrame() {
		setTitle("测试各种LookAndFeel的界面");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel radioPanel=new JPanel();
		JRadioButton radio1=new JRadioButton("A");
		JRadioButton radio2=new JRadioButton("B");
		ButtonGroup group=new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		radioPanel.add(radio1);
		radioPanel.add(radio2);
		radioPanel.setBorder(BorderFactory.createTitledBorder("JRadioButton"));
		
		JPanel checkPanel=new JPanel();
		checkPanel.add(new JCheckBox("123"));
		checkPanel.add(new JCheckBox("abc"));
		checkPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JPanel btnPanel=new JPanel();
		JButton btn1=new JButton("Button 1");
		btn1.setForeground(Color.orange);
		btnPanel.add(btn1);
		btnPanel.add(new JButton("Button 2"));
		btnPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), 
				BorderFactory.createRaisedSoftBevelBorder()));
		
		JPanel comboPanel=new JPanel();
		comboPanel.add(new JComboBox<>(new String[]{"ABC", "123", "中文"}));
		comboPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10),
				BorderFactory.createEtchedBorder()));
		
		JPanel spinnerPanel=new JPanel();
		spinnerPanel.add(new JSpinner());
		spinnerPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		
		JPanel all=new JPanel(new GridLayout(3, 2, 10, 10));
		all.add(radioPanel);
		all.add(checkPanel);
		all.add(btnPanel);
		all.add(comboPanel);
		all.add(spinnerPanel);
		
		JTabbedPane tabbedPane=new JTabbedPane();
		tabbedPane.addTab("Tab 1", all);
		tabbedPane.addTab("Tab 2", new JPanel());
		tabbedPane.addTab("Tab 3", new JPanel());
		tabbedPane.addTab("Tab 4", new JPanel());
		tabbedPane.addTab("Tab 5", new JPanel());
		
		setContentPane(tabbedPane);
		pack();
		setVisible(true);
	}
}
