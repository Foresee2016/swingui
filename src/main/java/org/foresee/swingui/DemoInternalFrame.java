package org.foresee.swingui;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JInternalFrame 支持在 JFrame
 * 窗口内部显示一个完整的子窗口，并提供了许多本机窗体功能的轻量级对象，包括拖动、关闭、变成图标、调整大小、标题显示和支持菜单栏等。 在实际使用中，通常将
 * JInternalFrame 添加到 JDesktopPane 中，由其来维护和显示 JInternalFrame。 JInternalFrame
 * 的实例创建后，其具体使用方法和 JFrame 类似。
 */
public class DemoInternalFrame {
	public static void main(String[] args) {
		JFrame frame=new JFrame("外部-调内部窗口");
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建桌面面板，内部窗口setLocation的位置相对于该桌面面板左上角
		JDesktopPane desktopPane=new JDesktopPane();
		JInternalFrame internalFrame=createInternalFrame();
		desktopPane.add(internalFrame);
		frame.setContentPane(desktopPane);
		frame.setVisible(true);
		try {
			internalFrame.setSelected(true); // 设置选中内部窗口
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JInternalFrame createInternalFrame() {
		JInternalFrame internalFrame = new JInternalFrame("内部窗口", true, true, true);
		internalFrame.setSize(200, 200);
		internalFrame.setLocation(50, 50); 
		// 默认关闭动作是销毁窗口，所以下边这一条是不用设置
		// internalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		JPanel panel=new JPanel();
		panel.add(new JLabel("Label 1"));
		panel.add(new JButton("Button 1"));
		internalFrame.setContentPane(panel);
		/*
         * 对于内部窗口，还可以不需要手动设置内容面板，直接把窗口当做普通面板使用，
         * 即直接设置布局，然后通过 add 添加组件，如下代码:
         *     internalFrame.setLayout(new FlowLayout());
         *     internalFrame.add(new JLabel("Label001"));
         *     internalFrame.add(new JButton("JButton001"));
         */
		internalFrame.setVisible(true);
		return internalFrame;
	}
}
