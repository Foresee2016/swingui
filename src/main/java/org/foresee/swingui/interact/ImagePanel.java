package org.foresee.swingui.interact;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JPanel;
/**
 * ImagePanel用来在JPanel背景上显示图像，可以通过BufferedImage或者BGR数组设置。
 * 因为是直接画在背景上的，所以Border会失效，即背景会扩展到边框区域上。
 */
public class ImagePanel extends JPanel {
	private static final long serialVersionUID = -57535165395930165L;
	private BufferedImage bufImage;
	public ImagePanel(int width, int height) {
		setSize(width, height);
		setPreferredSize(new Dimension(width, height));
		bufImage=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	}
	public void setBufImage(BufferedImage bufferedImage) {
		this.bufImage=bufferedImage;
		repaint();
	}
	public void setRasterBgrData(byte[] newData) {
		byte[] oldData=((DataBufferByte)bufImage.getRaster().getDataBuffer()).getData();
		for(int i=0; i<newData.length; i++){	
			oldData[i]=newData[i];
		}		
		repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (bufImage == null)
			return;
		g.drawImage(bufImage, 0, 0, this);
	}
}
