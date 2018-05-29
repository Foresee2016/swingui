package org.foresee.swingui.layout;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CardLayout，将容器内每个组件看作一张卡片，一次只能看到一张卡片，容器则充当卡片的堆栈，默认显示第一张卡片 。
 * 有first(),last(),next(),previous(),show()显示对应卡片
 */
public class DemoCardLayout {
	public static void main(String[] args) {
		JFrame frame=new JFrame("CardLayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		
		final CardLayout layout=new CardLayout(10, 15);
		JPanel panel=new JPanel(layout);
		panel.add(new JButton("Button 1"), "btn1");
		panel.add(new JButton("Button 2"), "btn2");
		panel.add(new JButton("Button 3"), "btn3");
		
		layout.show(panel, "btn2");
		frame.setContentPane(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// 2秒切换下一个card
		new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				layout.next(panel);
			}
		}).start();
	}
}
