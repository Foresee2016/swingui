package org.foresee.swingui.pane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 选项卡，用户点击标题或图标，在一组之间切换
 */
public class DemoJTabbedPane {

	public static void main(String[] args) {
		JFrame frame=new JFrame("分隔面板");
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		final JTabbedPane tabbedPane=new JTabbedPane();
		tabbedPane.addTab("Tab1", createTextPanel("TAB 1 Content"));
		tabbedPane.addTab("Tab2", createTextPanel("TAB 2 Content"));
		tabbedPane.addTab("Tab3", createTextPanel("TAB 3 Content"));
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent event) {
				System.out.println("当前选中："+event);
			}
		});
		tabbedPane.setSelectedIndex(1);
		frame.setContentPane(tabbedPane);
		frame.setVisible(true);
	}
	private static JComponent createTextPanel(String text) {
		JPanel panel=new JPanel(new GridLayout(1, 1));
		JLabel label=new JLabel(text);
		label.setFont(new Font(null, Font.PLAIN, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		return panel;
	}
}
