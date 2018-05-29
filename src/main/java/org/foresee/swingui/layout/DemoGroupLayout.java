package org.foresee.swingui.layout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GroupLayout 将组件按层次分组， 决定它们在容器中位置。GroupLayout主要供生成器使用（生成并行组和串行组）
 * 串行组（sequential group）按顺序指定方向（水平或垂直）依次放置元素
 * 并行组（parallel group）沿指定方向（水平或垂直）并行排列元素，能以四种不同方式对齐子元素
 * 分组由GroupLayout.Group类的实例完成，每组可以包含任意数量的元素（Group、Component、Gap）
 */
public class DemoGroupLayout {
	public static void main(String[] args) {
		JFrame frame=new JFrame("GroupLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel=new JPanel();
		GroupLayout layout=new GroupLayout(panel); // 创建布局，关联容器
		panel.setLayout(layout); //容器设置布局
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		JButton btn1=new JButton("Button 1");
		JButton btn2=new JButton("Button 2");
		JButton btn3=new JButton("Button 3");
		JButton btn4=new JButton("Button 4");
		JButton btn5=new JButton("Button 5");
		// 水平组，仅确定X轴方向的坐标或排列方式
		// 水平并行（上下）Btn1、Btn2
		GroupLayout.ParallelGroup hparaGroup1=layout.createParallelGroup().addComponent(btn1).addComponent(btn2);
		// 水平并行（上下）Btn3、Btn4
		GroupLayout.ParallelGroup hparaGroup2=layout.createParallelGroup().addComponent(btn3).addComponent(btn4);
		// 水平穿行（左右）hparaGroup1、hparaGroup2
		GroupLayout.SequentialGroup hSeqGroup=layout.createSequentialGroup().addGroup(hparaGroup1).addGroup(hparaGroup2);
		// 水平并行（上下）hSeqGroup、Btn5
		GroupLayout.ParallelGroup hParaGroup=layout.createParallelGroup().addGroup(hSeqGroup).addComponent(btn5);
		layout.setHorizontalGroup(hParaGroup); //指定布局的水平组（水平坐标）
		
		// 垂直组，仅确定Y方向的坐标或排列方式
		// 垂直并行（左右）btn1、btn3
		GroupLayout.ParallelGroup vParaGroup1=layout.createParallelGroup().addComponent(btn1).addComponent(btn3);
		// 垂直并行（左右）btn2、btn4
		GroupLayout.ParallelGroup vParaGroup2=layout.createParallelGroup().addComponent(btn2).addComponent(btn4);
		// 垂直串行（上下）vParaGroup1、vParaGroup2、btn5
		GroupLayout.SequentialGroup vSeqGroup=layout.createSequentialGroup().addGroup(vParaGroup1).addGroup(vParaGroup2).addComponent(btn5);
		layout.setVerticalGroup(vSeqGroup); //指定布局垂直组（垂直坐标）
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}
