package org.foresee.swingui.thread;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class DemoSwingWorker {
	public static void main(String[] args) {
		// 此处处于 主线程，提交任务到 事件调度线程 创建窗口
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// 此处处于 事件调度线程
				createUi();
			}
		});
	}

	public static void createUi() {
		JFrame frame = new JFrame("测试窗口");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		final JLabel label = new JLabel();
		label.setText("正在计算");
		panel.add(label);

		frame.setContentPane(panel);
		frame.setVisible(true);

		// 创建后台任务，关于SwingWorker的方法记在了Comment里
		SwingWorker<String, Object> task = new SwingWorker<String, Object>() {
			@Override
			protected String doInBackground() throws Exception {
				// 此处处于 SwingWorker 线程池中
				// 延时 5 秒，模拟耗时操作
				Thread.sleep(5000);
				// 返回计算结果
				return "Hello";
			}

			@Override
			protected void done() {
				// 此方法将在后台任务完成后在事件调度线程中被回调
				String result = null;
				try {
					// 获取计算结果
					result = get();
				} catch (Exception e) {
					e.printStackTrace();
				}
				label.setText("结算结果: " + result);
			}
		};

		// 启动任务
		task.execute();
	}
}
