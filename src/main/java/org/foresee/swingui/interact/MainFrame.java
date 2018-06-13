package org.foresee.swingui.interact;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 * 学习几个窗口之间的交互调用。并且分享同一个图像提供类
 */
public class MainFrame extends JFrame{
	private static final long serialVersionUID = -1380899323803594668L;
	public boolean running;
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			System.err.println("无法使用Nimbus观感，将使用默认Metal观感");
		}
		ImageProvider provider=new ImageProvider("cosmic640.jpg", "winnie640.jpg");
		MainFrame frame=new MainFrame(provider);
		while(frame.running){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("程序即将退出");
	}
	private ImageProvider provider;
	JButton oneBtn;
	JButton twoBtn;
	public MainFrame(ImageProvider provider) {
		this.provider=provider;
		initView();
		initController();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				provider.close();
				running=false;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		running=true;
		setTitle("学习多窗口交互");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void initView() {
		oneBtn=new JButton("Open FrameOne");
		oneBtn.setPreferredSize(new Dimension(180, 100));
		twoBtn=new JButton("Open FrameTwo");
		twoBtn.setPreferredSize(new Dimension(180, 100));
		
		JPanel onePanel=new JPanel(new BorderLayout());
		onePanel.add(oneBtn, BorderLayout.CENTER);
		onePanel.setBorder(createBorder10());
		JPanel twoPanel=new JPanel(new BorderLayout());
		twoPanel.add(twoBtn, BorderLayout.CENTER);
		twoPanel.setBorder(createBorder10());
		
		Box vBox=Box.createVerticalBox();
		vBox.add(onePanel);
		vBox.add(twoPanel);
		
		setContentPane(vBox);
	}
	private void initController() {
		WindowAdapter windowAdapter=new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				mainVisible(true);
			}
		};
		MouseAdapter adapter=new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(e.getSource()==oneBtn){
					new FrameOne(provider).addWindowListener(windowAdapter);;
					mainVisible(false);
				}
				if(e.getSource()==twoBtn){
					new FrameTwo(provider).addWindowListener(windowAdapter);;
					mainVisible(false);
				}
			}
		};
		oneBtn.addMouseListener(adapter);
		twoBtn.addMouseListener(adapter);
	}
	private void mainVisible(boolean visible) {
		setVisible(visible);
	}
	private Border createBorder10() {
		return BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10),
				BorderFactory.createRaisedBevelBorder());
	}
}
