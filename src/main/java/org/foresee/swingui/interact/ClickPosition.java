package org.foresee.swingui.interact;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
// @formatter:off
/**
 * 鼠标在JPanel上时变为手指，点击时获取JPanel上的点击位置。
 * NOTE：根据点击位置来看，JPanel的Border是属于它内部的一部分，即如果四周有10的Empty边框，那图像左上角坐标是10.
 * 如果有更多的组合边框，那么会继续向右下移动。
 * 不同的是ImagePanel（自定义的类），因为图像画在背景上，填充了整个区域，所以图像的左上角就是(0,0)位置。
 */
public class ClickPosition { 
// @formatter:on

	public static void main(String[] args) {
		JFrame frame = new JFrame("JPanel点击位置");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel tip=new JLabel("点击中间图像的位置，获取坐标值");
		JLabel pos=new JLabel("点击位置");
		
		JPanel panel = new JPanel();
		ImageIcon icon = new ImageIcon("winnie640.jpg");
		panel.add(new JLabel(icon));
		panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10),
				BorderFactory.createLoweredBevelBorder()));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.out.println("X = " + e.getX() + ", Y = " + e.getY());
				pos.setText("点击位置：X = " + e.getX() + ", Y = " + e.getY());
			}
		});

		frame.setLayout(new BorderLayout());
		try {
			BufferedImage bufImg = ImageIO.read(new FileInputStream("mario128.jpg"));
			ImagePanel imgPanel=new ImagePanel(bufImg.getWidth(), bufImg.getHeight());
			imgPanel.setBufImage(bufImg);
			imgPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
			imgPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			imgPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					System.out.println("X = " + e.getX() + ", Y = " + e.getY());
					pos.setText("点击位置：X = " + e.getX() + ", Y = " + e.getY());
				}
			});
			frame.add(imgPanel, BorderLayout.EAST);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		frame.add(tip, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(pos, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
