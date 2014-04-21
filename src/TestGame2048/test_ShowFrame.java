package TestGame2048;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
/*
 * Listen Frame
 */
public class test_ShowFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // Added by Eclipse
	public final static int ROW = 4;
	public final static int COLUMN = 4;
	
	public test_ShowFrame showFrame;

	public void init() {
		showFrame = new test_ShowFrame();
		showFrame.setSize(780, 500);
		showFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showFrame.setResizable(false);
		showFrame.setTitle("204fff8");
		
		myKeyEventPostProcessor keyEventPostProcessor = new myKeyEventPostProcessor();
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		//然后得到当前键盘事件的管理器
		manager.addKeyEventPostProcessor(keyEventPostProcessor);
		//然后为管理器添加一个新的键盘事件监听者。

		Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED,
				new Color(45, 92, 162), new Color(43, 66, 97), new Color(45,
						92, 162), new Color(84, 123, 200)); // Set Border

		JPanel toolBar = new JPanel();
		toolBar.setBackground(Color.white);
		toolBar.setBorder(border);
		toolBar.setPreferredSize(new Dimension(780, 48));

		JPanel actionPanel = new JPanel();
		actionPanel.setBackground(Color.yellow);
		actionPanel.setPreferredSize(new Dimension(160, 380));

		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.blue);
		contentPanel.setPreferredSize(new Dimension(620, 380));

		showFrame.getContentPane().add(toolBar, BorderLayout.NORTH);
		showFrame.getContentPane().add(actionPanel, BorderLayout.EAST);
		showFrame.getContentPane().add(contentPanel, BorderLayout.CENTER);

	}
	
	public class myKeyEventPostProcessor implements KeyEventPostProcessor {
		public boolean postProcessKeyEvent(KeyEvent e) {
			if(e.getKeyCode() == 16) {
				System.out.println("112233");
				return true;
			}
			return true;
		}
	}
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		test_ShowFrame showFrame = new test_ShowFrame();
		showFrame.init();
		showFrame.showFrame.show();
	}
}
