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

public class FrameOne extends JFrame{
	private static final long serialVersionUID = 2770241685976689585L;
	private ImageProvider provider;
	JLabel label;
	JButton refreshBtn;
	public FrameOne(ImageProvider provider) {
		this.provider=provider;
		initView();
		initController();
		setTitle("FrameOne");
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
