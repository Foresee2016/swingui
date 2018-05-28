package org.foresee.swingui.dialog;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PropertyDialog  extends JDialog{
	private static final long serialVersionUID = 866796980709208707L;
	JTextField keyField;
	JTextField valueField;
	JButton okBtn;
	JButton cancelBtn;
	PropertyDialogCallback callback;
	Property property;
	public PropertyDialog(JFrame owner, Component parentComponent, PropertyDialogCallback callback) {
		super(owner, "添加属性对话框", true);
		
		initModel(callback);
		initView();
		initController();
		
		setSize(400, 300);
		setResizable(false);
		setLocationRelativeTo(parentComponent);
		setVisible(true);
	}
	protected void initModel(PropertyDialogCallback callback) {
		this.callback=callback;
		property=new Property("", "");
	}
	protected void initView() {
		//LayoutManager manager=new BoxLayout(this, BoxLayout.Y_AXIS);
		//setLayout(manager);
		
		JLabel keyLabel=new JLabel("键名");
		keyField=new JTextField("在此输入键名");
		JPanel keyPanel=new JPanel();
		//LayoutManager hManager=new BoxLayout(keyPanel.get, BoxLayout.X_AXIS);
		//keyPanel.setLayout(hManager);
		keyPanel.add(keyLabel);
		keyPanel.add(keyField);
		keyPanel.setSize(300, 100);
		
		JLabel valueLabel=new JLabel("值");
		valueField=new JTextField("在此输入值");
		JPanel valuePanel=new JPanel();
		//LayoutManager hManager2=new BoxLayout(valuePanel, BoxLayout.X_AXIS);
		//valuePanel.setLayout(hManager2);
		valuePanel.add(valueLabel);
		valuePanel.add(valueField);
		valuePanel.setSize(300, 100);
		
		okBtn=new JButton("确定");
		cancelBtn=new JButton("取消");
		JPanel btnPanel=new JPanel();
		//LayoutManager hManager3=new BoxLayout(btnPanel, BoxLayout.X_AXIS);
		//btnPanel.setLayout(hManager3);
		btnPanel.add(okBtn);
		btnPanel.add(cancelBtn);
		
		JPanel allPanel=new JPanel();
		allPanel.add(keyPanel);
		allPanel.add(valuePanel);
		allPanel.add(btnPanel);
		setContentPane(allPanel);
	}
	protected void initController() {
		okBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				property.key=keyField.getText();
				property.value=valueField.getText();
				callback.onFinishInput(property);
				dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				dispose();
			}
		});
	}
	public interface PropertyDialogCallback{
		void onFinishInput(Property property);
	}
}
