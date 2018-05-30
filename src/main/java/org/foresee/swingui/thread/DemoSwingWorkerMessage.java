package org.foresee.swingui.thread;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class DemoSwingWorkerMessage {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createUi();
			}
		});
	}
	public static void createUi() {
		JFrame frame = new JFrame("SwingWorker发布事件");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        final JLabel label = new JLabel("正在下载: 0%");
        panel.add(label, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setVisible(true);

        // 创建后台任务
        SwingWorker<String, Integer> task = new SwingWorker<String, Integer>() {
            @Override
            protected String doInBackground() throws Exception {
                for (int i = 0; i < 100; i += 10) {
                    // 延时模拟耗时操作
                    Thread.sleep(1000);

                    // 设置 progress 属性的值（通过属性改变监听器传递数据到事件调度线程）
                    setProgress(i);

                    // 通过 SwingWorker 内部机制传递数据到事件调度线程
                    publish(i);
                }
                // 返回计算结果
                return "下载完成";
            }

            @Override
            protected void process(List<Integer> chunks) {
                // 此方法在 调用 doInBackground 调用 public 方法后在事件调度线程中被回调
                Integer progressValue = chunks.get(0);
                textArea.append("已下载: " + progressValue + "%\n");
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
                label.setText(result);
                textArea.append(result);
            }
        };

        // 添加属性改变监听器
        task.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("progress".equals(evt.getPropertyName())) {
                    Object progressValue = evt.getNewValue();
                    label.setText("正在下载: " + progressValue + "%");
                }
            }
        });

        // 启动任务
        task.execute();
	}
}
