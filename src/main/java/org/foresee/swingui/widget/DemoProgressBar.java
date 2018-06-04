package org.foresee.swingui.widget;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 进度条中心可显示进度百分比的文本表示形式。
 * 当一个任务的进度长度未知时，可将进度条设置为不确定模式。不确定模式的进度条持续地显示动画来表示正进行的操作。
 * 当可以确定任务长度和进度量时，则可设置进度条的最大最小值，以及更新进度条的进度值，将其切换回确定模式。
 */
public class DemoProgressBar {
	static final int MIN_PROGRESS=0;
	static final int MAX_PROGRESS=50;
	static int currentProgress=MIN_PROGRESS;
	public static void main(String[] args) {
		JFrame frame=new JFrame("进度条-确定进度的");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		JProgressBar progressBar=new JProgressBar();
		progressBar.setMinimum(MIN_PROGRESS);
		progressBar.setMaximum(MAX_PROGRESS);
		progressBar.setValue(currentProgress);
		progressBar.setStringPainted(true); //绘制百分比在进度条中心
		progressBar.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("当前进度："+progressBar.getValue()+", 百分比"+progressBar.getPercentComplete());
			}
		});	
		panel.add(progressBar);
		frame.setContentPane(panel);
		frame.setVisible(true);
		
		new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				currentProgress++;
				if(currentProgress>MAX_PROGRESS){
					currentProgress=MIN_PROGRESS;
				}
				progressBar.setValue(currentProgress);
			}
		}).start();
	}
}
