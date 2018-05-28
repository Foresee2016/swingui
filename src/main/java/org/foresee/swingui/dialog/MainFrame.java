package org.foresee.swingui.dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import org.foresee.swingui.dialog.PropertyDialog.PropertyDialogCallback;

public class MainFrame  extends JFrame implements PropertyDialogCallback{
	private static final long serialVersionUID = 2755939177980775487L;
	private List<Property> properties;
	JButton addBtn;
	JButton msgBtn;
	JButton confirmBtn;
	JButton inputBtn;
	JButton optionBtn;
	JToggleButton toggleBtn;
	public MainFrame() {
		initModel();
		initView();
		initController();
	}
	protected void initModel() {
		properties = new ArrayList<>();
		// properties.add(new Property("示例键", "示例值"));
	}
	protected void initView() {
		setLayout(new FlowLayout());
		addBtn = new JButton("添加属性");
		addBtn.setSize(100, 40);
		add(addBtn);
		msgBtn=new JButton("提示消息对话框");
		msgBtn.setSize(150, 40);
		add(msgBtn);
		confirmBtn=new JButton("确认对话框");
		confirmBtn.setSize(100, 40);
		add(confirmBtn);
		inputBtn=new JButton("输入对话框");
		inputBtn.setSize(100, 40);
		add(inputBtn);
		optionBtn=new JButton("选项对话框");
		optionBtn.setSize(100, 40);
		add(optionBtn);		
		toggleBtn=new JToggleButton("开关按钮");
		toggleBtn.setSize(100, 40);
		add(toggleBtn);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 得到屏幕的尺寸
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
		setSize(500, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	protected void initController() {
		addBtn.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				new PropertyDialog(MainFrame.this, MainFrame.this, MainFrame.this);
			}
		});
		msgBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				JOptionPane.showMessageDialog(rootPane, "提示信息", "标题名称", JOptionPane.PLAIN_MESSAGE);
			}
		});
		confirmBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				int res=JOptionPane.showConfirmDialog(rootPane, "提示信息");
				System.out.println(res);
			}
		});
		inputBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				String res=JOptionPane.showInputDialog("提示信息");
				System.out.println(res);
			}
		});
		optionBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				super.mouseClicked(arg0);
				Object[] selectionValues = new Object[]{"香蕉", "雪梨", "苹果"};
				Object res=JOptionPane.showOptionDialog(rootPane, "选项对话框", "对话框标题", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, selectionValues, selectionValues[0]);
				System.out.println(res);
			}
		});
		
	}
	public int addProperties(Property property) {
		properties.add(property);
		System.out.println(property);
		return properties.size();
	}

	public List<Property> getProperties() {
		return properties;
	}

	@Override
	public void onFinishInput(Property property) {
		System.out.println(property);
		properties.add(property);
	}
}
