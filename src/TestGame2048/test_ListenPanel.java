package TestGame2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 在JPanel中监听键盘事件 By [url=http://eastsun.javaeye.com]Eastsun[/url]
 */
public class test_ListenPanel {
	public static void main(String[] args) {
		JFrame frame = new JFrame("KeyLis");
		final JLabel label = new JLabel("key press: ");
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(320, 240));
		panel.add(label);
		panel.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
				
			}
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				label.setText("key press:" + e.getKeyCode());
			}
		});
		panel.setFocusable(true);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}