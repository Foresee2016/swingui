package org.foresee.swingui.pane;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * JLayeredPane 按深度分层，每层内按位置划分，
 * 允许层叠，层编号大的在前面，同一层内，位置编号越大的越靠近底部。
 * setLayer(Component c, int layer)设置层
 * 同一层内，moveToFront(), moveToBack(),setPosition()调整 
 */
public class DemoJLayeredPane {
	public static void main(String[] args) {
		JFrame frame = new JFrame("测试窗口");
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();

        // 层数: 100
        JPanel panel_100_1 = createPanel(Color.RED, "L=100, P=1", 30, 30, 100, 100);
        layeredPane.add(panel_100_1, new Integer(100));

        // 层数: 200, 层内位置: 0（层内顶部）
        JPanel panel_200_0 = createPanel(Color.GREEN, "L=200, P=0", 70, 70, 100, 100);
        layeredPane.add(panel_200_0, new Integer(200), 0);

        // 层数: 200, 层内位置: 1
        JPanel panel_200_1 = createPanel(Color.CYAN, "L=200, P=1", 110, 110, 100, 100);
        layeredPane.add(panel_200_1, new Integer(200), 1);

        // 层数: 300
        JPanel panel_300 = createPanel(Color.YELLOW, "L=300", 150, 150, 100, 100);
        layeredPane.add(panel_300, new Integer(300));

        frame.setContentPane(layeredPane);
        frame.setVisible(true);
	}
	private static JPanel createPanel(Color bg, String text, int x, int y, int width, int height) {
        // 创建一个 JPanel, 使用 1 行 1 列的网格布局
        JPanel panel = new JPanel(new GridLayout(1, 1));

        // 设置容器的位置和宽高
        panel.setBounds(x, y, width, height);

        // 设置 panel 的背景
        panel.setOpaque(true);
        panel.setBackground(bg);

        // 创建标签并设置相应属性
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.TOP);

        // 添加标签到容器
        panel.add(label);

        return panel;
    }
}
