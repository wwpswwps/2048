package TestGame2048;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class TopContainer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // Added by Eclipse

	private JButton about = new JButton("about");
	
	public final static int ROW = 4;
	public final static int COLUMN = 4;
	
	public TopContainer() {
		this.setSize(780, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("2048");
		
		
		
		
		
		Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED,
				new Color(45, 92, 162),
				new Color(43, 66, 97),
				new Color(45, 92, 162),
				new Color(84, 123, 200)); // Set Border
		
		JPanel toolBar = new JPanel();
//		toolBar.setBackground(Color.white);
		toolBar.setBorder(border);
		toolBar.setPreferredSize(new Dimension(780, 48));
		
		toolBar.add(about);
		JButton test = new JButton("test");
		test.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(new TopContainer(), "adf", "asd", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		toolBar.add(test);
		
		MyListener myListener = new MyListener();
		about.addActionListener(myListener);
		
		
		JPanel actionPanel = new JPanel();
		actionPanel.setBackground(Color.yellow);
		actionPanel.setPreferredSize(new Dimension(160, 380));
		
		actionPanel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
			}
		});
		
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.blue);
		contentPanel.setPreferredSize(new Dimension(620, 380));
		
		contentPanel.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
			}
		});
		
		GridLayout gridLayout = new GridLayout(ROW, COLUMN);
		contentPanel.setLayout(gridLayout);
		
		JButton[] dots = new JButton[ROW * COLUMN];
		for(int i = 0; i < ROW * COLUMN; i++) {
			ImageIcon imageIcon = new ImageIcon("C:/Users/xxl/Desktop/a.jpg");
			dots[i] = new JButton(imageIcon);
			dots[i].setActionCommand("" + i);
			contentPanel.add(dots[i]);
			dots[i].addActionListener(myListener);
		}
		
		
		
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		this.getContentPane().add(actionPanel, BorderLayout.EAST);
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		actionPanel.setFocusable(true);
		System.out.println("asdf");
	}

	private class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == about) {
				JOptionPane.showMessageDialog(new TopContainer(), "My Name", "about", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(e.getSource() instanceof JButton) {
				JButton button = (JButton)e.getSource();
				int offset = Integer.parseInt(button.getActionCommand());
				System.out.println(offset);
				int row, col;
				
				row = Math.round(offset/COLUMN);
				col = offset - row * COLUMN;
				
				JOptionPane.showMessageDialog(new TopContainer(), "ROW = " + row + ", COL = " + col, "Button", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	Image getImage(String filename) {
		URLClassLoader urlLoader = (URLClassLoader)this.getClass().getClassLoader();
		URL url = null;
		Image image = null;
		url = urlLoader.findResource(filename);
		image = Toolkit.getDefaultToolkit().getImage(url);
		return image;
	}

//	private class myKeyListener implements KeyListener {
//
//		public void keyTyped(KeyEvent e) {
//			// TODO Auto-generated method stub
//			char c = e.getKeyChar();  
//	        /* 注意getKeyChar()的用法 */  
//	        if (c == 'o') {  
//	            JFrame newF = new JFrame("新窗口");  
//	            newF.setSize(200, 200);  
//	            newF.setVisible(true);  
//	        } 
//			
//		}
//		
//
//		public void keyReleased(KeyEvent e) {
//			if(e.getKeyCode() == 16)
//				System.out.println("asdfasdfasdf");
//			
//		}
//		public void keyPressed(KeyEvent e) {
//			if(e.getKeyCode() == 16)
//				System.out.println("asdfasdfasdf");
//		}
//	}

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		TopContainer topContainer = new TopContainer();
		topContainer.show();
	}
}
