package org.foresee.swingui.interact;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameTwo extends JFrame{
	private static final long serialVersionUID = 6027092080837392874L;
	private ImageProvider provider;
	JLabel label;
	JButton refreshBtn;
	JButton outputBtn;
	public FrameTwo(ImageProvider provider) {
		this.provider=provider;
		initView();
		initController();
		setTitle("FrameTwo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void initView() {
		setLayout(new BorderLayout());
		label=new JLabel();
		refreshIcon();
		add(label, BorderLayout.CENTER);
		
		Box hBox=Box.createHorizontalBox();
		refreshBtn=new JButton("刷新");
		refreshBtn.setPreferredSize(new Dimension(150, 40));
		hBox.add(refreshBtn);
		
		outputBtn=new JButton("输出");
		outputBtn.setPreferredSize(new Dimension(100, 30));
		hBox.add(outputBtn);
		add(hBox, BorderLayout.SOUTH);
	}
	private void initController() {
		refreshBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				refreshIcon();
			}
		});
		outputBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				System.out.println("从FrameTwo输出一些信息");
			}
		});
	}
	private boolean refreshIcon() {
		ImageIcon icon=provider.refresh();
		if(icon==null){
			label.setText("<html>图像错误<br>无法取得</html>");
			return false;
		}else {
			label.setIcon(icon);
			return true;
		}
	}
}
