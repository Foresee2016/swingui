package org.foresee.swingui.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
/**
 * 创建窗口的正确方式 
 */
public class DemoStartUiThread {
	public static void main(String[] args) {
		// 此处处于 主线程，提交任务到 事件调度线程 创建窗口
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// 此处处于 事件调度线程
				createGUI();
			}
		});
	}
	 public static void createGUI() {
	        // 此处处于 事件调度线程
	        JFrame frame = new JFrame("测试窗口");
	        frame.setSize(300, 300);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel();

	        JButton btn = new JButton("Btn");
	        btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 此处处于 事件调度线程（所有监听器的回调都在 事件调度线程 中回调）
	            }
	        });

	        frame.setContentPane(panel);
	        frame.setVisible(true);
	    }
}
