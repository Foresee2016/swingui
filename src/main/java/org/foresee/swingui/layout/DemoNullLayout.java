package org.foresee.swingui.layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 设置布局为null，绝对布局，没有管理器，组件设置自己的坐标和宽高。每个组件都要明确设置，否则不显示。
 * 使用其它布局时，在窗口显示之后，再添加新组建，或者修改之前添加组件的坐标和宽高，该组件将被视为绝对布局（会让设置生效） 
 * setLocation(),setSize(),setBounds()
 */
public class DemoNullLayout {
	public static void main(String[] args) {
		JFrame frame = new JFrame("测试窗口");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建内容面板，指定布局为 null，则使用绝对布局
        JPanel panel = new JPanel(null);

        // 创建按钮
        JButton btn1 = new JButton("Button1");
        // 设置按钮的坐标
        btn1.setLocation(50, 50);
        // 设置按钮的宽高
        btn1.setSize(100, 50);
        panel.add(btn1);

        // 创建按钮
        JButton btn2 = new JButton("Button2");
        // 设置按钮的界限(坐标和宽高)，设置按钮的坐标为(50, 100)，宽高为 100, 50
        btn2.setBounds(50, 100, 100, 50);
        panel.add(btn2);

        // 显示窗口
        frame.setContentPane(panel);
        frame.setVisible(true);

        /*
         * 也可以在 frame.setVisible(true) 之后添加按钮
         *
         * PS_01: frame.setVisible(true) 之后，内容面板才有宽高;
         * PS_02: 使用其他布局时, frame.setVisible(true) 之后添加的组件, 也会被当做是绝对布局来布置该组件（即需要手动指定坐标和宽高）;
         * PS_03: 使用其他布局时, frame.setVisible(true) 之前添加的组件, 如果在 frame.setVisible(true) 之后手动设置该组件的坐标和宽高,
         *        会将该组件当做绝对布局来对待（即设置坐标和宽高会生效）。
         */
        JButton btn3 = new JButton("Button3");
        // 把按钮位置设置在内容面板右下角, 并且设置按钮宽高为 100, 50
        btn3.setBounds(panel.getWidth() - 100, panel.getHeight() - 50, 100, 50);
        panel.add(btn3);
	}
}
