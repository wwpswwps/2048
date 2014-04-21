package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
 * Author:		Xiaolong Xu
 * Email:		mrxuxiaolong@gmail.com
 * Linkedin: 	www.linkedin.com/pub/xiaolong-xu/4b/778/125/
 */

public class Container {
	JFrame frame;
	JPanel scorePanel;
	JPanel contentPanel;
	
	JPanel scorePanel_Logo;
	JPanel scorePanel_Score;
	JPanel scorePanel_Bt;
	
	JPanel scorePanel_Score_Score;
	
	JLabel scoreLabel;
	
	String aboutInfo = "<html><font face = 'Century Gothic' size = '6'><center>2048 - Game V1.0</center></font><font face = 'Century Gothic' size = '5'><br><br><br>Author:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Xiaolong Xu&nbsp;&nbsp;@&nbsp;&nbsp;Apr 20, 2014<br><br>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;mrxuxiaolong@gmail.com<br><br>Linkedin:&nbsp;&nbsp;&nbsp;www.linkedin.com/pub/xiaolong-xu/4b/778/125/<br><br><br></font><font face = 'Century Gothic' size = '3'><center>Personal Project - Java Swing Practice</center></font></html>";
	String greetMsg = "<html>Enjoy the fantastic game!<br><br></html>";
	String authorMsg = "<html><font size = '2'>Author: Xiaolong Xu<br>mrxuxiaolong@gmail.com</font></html>";
	String scoreHtmlFirst = "<html><font face = 'Broadway' size = '6' color='white'><Strong>SCORE</Strong></font><br><br><font face = 'Broadway' size = '6' color='white'><Strong>";
	String scoreHtmlLast = "</Strong></font></html>";
	
	int score;
	int countHit2048;
	
	int dirLen = (Container.class.getResource("/img/")).toString().length();
	ImageIcon startGameIcon = new ImageIcon(Container.class.getResource("/img/startgame.png"));
	ImageIcon startGameHoverIcon = new ImageIcon(Container.class.getResource("/img/startgame_hover.png"));
	ImageIcon logoIcon = new ImageIcon(Container.class.getResource("/img/logo.png"));
	ImageIcon logoHoverIcon = new ImageIcon(Container.class.getResource("/img/logo_hover.png"));
	
	ImageIcon[] icons = {new ImageIcon(Container.class.getResource("/img/blank.png")),
						 new ImageIcon(Container.class.getResource("/img/2.png")),
						 new ImageIcon(Container.class.getResource("/img/4.png")),
						 new ImageIcon(Container.class.getResource("/img/8.png")),
						 new ImageIcon(Container.class.getResource("/img/16.png")),
						 new ImageIcon(Container.class.getResource("/img/32.png")),
						 new ImageIcon(Container.class.getResource("/img/64.png")),
						 new ImageIcon(Container.class.getResource("/img/128.png")),
						 new ImageIcon(Container.class.getResource("/img/256.png")),
						 new ImageIcon(Container.class.getResource("/img/512.png")),
						 new ImageIcon(Container.class.getResource("/img/1024.png")),
						 new ImageIcon(Container.class.getResource("/img/2048.png")),
						 new ImageIcon(Container.class.getResource("/img/4096.png"))
						};
	
	private static int ROW = 4;
	private static int COL = 4;
	
	JButton[] cell = new JButton[ROW * COL];
	
	Border defaultBorder = BorderFactory.createEmptyBorder();
	
	public Container() {
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		frame = new JFrame();
		
		// Set top frame
		frame.setSize(800, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("2048");
		
		// Set panels	
		Color scorePanelBgColor = new Color(250, 248, 239);
		Color scoreSubBgColor = new Color(187, 173, 160);
		
		scorePanel = new JPanel();		
		scorePanel.setBackground(scorePanelBgColor);
		scorePanel.setPreferredSize(new Dimension(186, 614));
		
		
		scorePanel_Logo = new JPanel();
		scorePanel_Score = new JPanel();
		scorePanel_Bt = new JPanel();
		scorePanel_Score_Score = new JPanel();
		
		scorePanel_Logo.setBackground(scorePanelBgColor);
		scorePanel_Score.setBackground(scorePanelBgColor);
		scorePanel_Bt.setBackground(scorePanelBgColor);
		scorePanel_Score_Score.setBackground(scoreSubBgColor);
		
		scorePanel_Logo.setPreferredSize(new Dimension(186, 186));
		scorePanel_Score.setPreferredSize(new Dimension(186, 300));
		scorePanel_Bt.setPreferredSize(new Dimension(186, 50));
		scorePanel_Score_Score.setPreferredSize(new Dimension(150, 200));
		
		scorePanel_Logo.setLayout(null);
		scorePanel_Bt.setLayout(null);
		
		final JButton logoBt = new JButton(logoIcon);
		logoBt.setBounds(18, 18, 150, 150);
		logoBt.setBorder(defaultBorder);
		logoBt.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				logoBt.setIcon(logoIcon);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				logoBt.setIcon(logoHoverIcon);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		logoBt.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog about = new JDialog();
				about.setTitle("About");
				about.setSize(600, 350);
				about.setResizable(false);
				about.add(new JLabel(aboutInfo));
				about.show();
			}
		});
		scorePanel_Logo.add(logoBt);
		
		JLabel greet = new JLabel(greetMsg);
		scorePanel_Score.add(greet);
		scorePanel_Score.add(scorePanel_Score_Score, BorderLayout.CENTER);
		JLabel authorInfo = new JLabel(authorMsg);
		scorePanel_Score.add(authorInfo);
		

		scoreLabel = new JLabel(scoreHtmlFirst + score + scoreHtmlLast);
		scorePanel_Score_Score.add(scoreLabel);
		
		scorePanel.add(scorePanel_Logo, BorderLayout.NORTH);
		scorePanel.add(scorePanel_Score, BorderLayout.CENTER);
		scorePanel.add(scorePanel_Bt, BorderLayout.SOUTH);
		
		Color contentPanelColor = new Color(187, 173, 160);
		Border contentPanelBorder = BorderFactory.createLineBorder(contentPanelColor, 7);
		
		contentPanel = new JPanel();		
		contentPanel.setBackground(contentPanelColor);
		contentPanel.setPreferredSize(new Dimension(614, 614));
		
		contentPanel.setBorder(contentPanelBorder);
		
		
		// Add panels to frame
		frame.getContentPane().add(scorePanel, BorderLayout.EAST);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		// Set layout for contentPanel
		GridLayout gridLayout = new GridLayout(ROW, COL);
		contentPanel.setLayout(gridLayout);
		
		// Construct cells		
		for(int i = 0; i < ROW * COL; i++) {
			cell[i] = new JButton(icons[0]);
			cell[i].setBorder(defaultBorder);
			contentPanel.add(cell[i]);
		}
		

		// Add key listener to contentPanel
		setKeyListener(contentPanel);
		
		// StartGame button
		final JButton startGame = new JButton();
		startGame.setBounds(18, 5, 150, 40);
		startGame.setBorder(defaultBorder);
		startGame.setIcon(startGameIcon);
		startGame.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				startGame.setIcon(startGameIcon);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				startGame.setIcon(startGameHoverIcon);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				initCells();
				startGame();				
			}
		});
		scorePanel_Bt.add(startGame);
		
	}
	// contentPanel KeyListener
	public void setKeyListener(Component component) {
		component.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(isGameOver()) {
					int result = JOptionPane.showConfirmDialog(frame, "No more movement can be made.\nPlease try another time!", "Game Over", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

					if(result == JOptionPane.OK_OPTION) {
						initCells();
						startGame();
						return;
					}
				}
				switch (e.getKeyCode()) {
				case 37:
					moveLeft();
					break;
				case 38:
					moveUp();
					break;
				case 39:
					moveRight();
					break;
				case 40:
					moveDown();
					break;
				default:
					break;
				}
			}
		});
	}
	// Add focus action on cell[]
	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			contentPanel.requestFocus();
		}
	}
	
	// Initialize game and make contentPanel get focus
	public void startGame() {
		for(int i = 0; i < ROW * COL; i++) {
			MyActionListener myActionListener = new MyActionListener();
			cell[i].addActionListener(myActionListener);
		}
		setNumForAvailableCell();
		setNumForAvailableCell();
		contentPanel.requestFocus(); // Make contentPanel focused
	}
	
	public ImageIcon createRdNum() {
		Random random = new Random();
		int rd = random.nextInt(10);
		if(rd >= 7)
			return icons[2];// 30% "4" created
		return icons[1];// 70% "2" created
	}
	
	// Find all available cells (icon is icon_blank ones), and set one of them a random number (2 or 4)
	public void setNumForAvailableCell() {
		ArrayList<JButton> availableCells = new ArrayList<JButton>();
		for(JButton bt : cell) {
			if(bt.getIcon() == icons[0])
				availableCells.add(bt);
		}
		
		int seed = availableCells.size();
		if(seed <= 0)
			return; // When all cells are not empty, no more number is new created
		Random random = new Random();
		int rdIndex = random.nextInt(seed);
		
		availableCells.get(rdIndex).setIcon(createRdNum());
	}

	// Cells' movement
	public void moveLeft() {
		JButton[] temp = new JButton[ROW * COL];
		for(int k = 0; k < ROW * COL; k++) {
			temp[k] = new JButton(cell[k].getIcon());
		}
		moveLeftHelper();
		if(mergeCellToLeft())
			return;
		if(!isEqual(cell, temp)) {
			rmBorder();
			setNumForAvailableCell(); // Add to each movement, because every movement needs a new number created
		}
	}

	public void moveRight() {
		JButton[] temp = new JButton[ROW * COL];
		for(int k = 0; k < ROW * COL; k++) {
			temp[k] = new JButton(cell[k].getIcon());
		}
		moveRightHelper();
		if(mergeCellToRight())
			return;
		if(!isEqual(cell, temp)) {
			rmBorder();
			setNumForAvailableCell(); // Add to each movement, because every movement needs a new number created
		}
	}

	public void moveUp() {
		JButton[] temp = new JButton[ROW * COL];
		for(int k = 0; k < ROW * COL; k++) {
			temp[k] = new JButton(cell[k].getIcon());
		}
		moveUpHelper();
		if(mergeCellToUp())
			return;
		if(!isEqual(cell, temp)) {
			rmBorder();
			setNumForAvailableCell(); // Add to each movement, because every movement needs a new number created
		}
	}

	public void moveDown() {
		JButton[] temp = new JButton[ROW * COL];
		for(int k = 0; k < ROW * COL; k++) {
			temp[k] = new JButton(cell[k].getIcon());
		}
		moveDownHelper();
		if(mergeCellToDown())
			return;
		if(!isEqual(cell, temp)) {
			rmBorder();
			setNumForAvailableCell(); // Add to each movement, because every movement needs a new number created
		}
	}

	public void moveLeftHelper() {
		ArrayList<ArrayList<Icon>> rowList = new ArrayList<ArrayList<Icon>>();
		for(int i = 0; i < ROW; i++) {
			ArrayList<Icon> temp = new ArrayList<Icon>();
			for(int j = 0; j < COL; j++) {
				temp.add(cell[COL * i + j].getIcon());
			}
			rowList.add(moveLeftAndUpReorder(temp));
		}
		for(int m = 0; m < ROW; m++) {
			for(int n = 0; n < COL; n++) {
				cell[COL * m + n].setIcon(rowList.get(m).get(n));
			}
		}
	}
	public void moveRightHelper() {
		ArrayList<ArrayList<Icon>> rowList = new ArrayList<ArrayList<Icon>>();
		for(int i = 0; i < ROW; i++) {
			ArrayList<Icon> temp = new ArrayList<Icon>();
			for(int j = 0; j < COL; j++) {
				temp.add(cell[COL * i + j].getIcon());
			}
			rowList.add(moveRightAndDownReorder(temp));
		}
		for(int m = 0; m < ROW; m++) {
			for(int n = 0; n < COL; n++) {
				cell[COL * m + n].setIcon(rowList.get(m).get(n));
			}
		}
	}	
	public void moveUpHelper() {
		ArrayList<ArrayList<Icon>> colList = new ArrayList<ArrayList<Icon>>();
		for(int i = 0; i < COL; i++) {
			ArrayList<Icon> temp = new ArrayList<Icon>();
			for(int j = 0; j < ROW; j++) {
				temp.add(cell[ROW * j + i].getIcon());
			}
			colList.add(moveLeftAndUpReorder(temp));
		}
		for(int m = 0; m < COL; m++) {
			for(int n = 0; n < ROW; n++) {
				cell[ROW * n + m].setIcon(colList.get(m).get(n));
			}
		}
		
	}
	public void moveDownHelper() {
		ArrayList<ArrayList<Icon>> colList = new ArrayList<ArrayList<Icon>>();
		for(int i = 0; i < COL; i++) {
			ArrayList<Icon> temp = new ArrayList<Icon>();
			for(int j = 0; j < ROW; j++) {
				temp.add(cell[ROW * j + i].getIcon());
			}
			colList.add(moveRightAndDownReorder(temp));
		}
		for(int m = 0; m < COL; m++) {
			for(int n = 0; n < ROW; n++) {
				cell[ROW * n + m].setIcon(colList.get(m).get(n));
			}
		}
	}
	
	public ArrayList<Icon> moveLeftAndUpReorder(ArrayList<Icon> arr) {
		int len = arr.size();
		JButton flag = new JButton(icons[0]);
		int countBlank = 0;
		for(int i = 0; i < len; i++) {
			if(arr.get(i) == flag.getIcon())
				countBlank++;
		}
		ArrayList<Icon> result = new ArrayList<Icon>();
		for(int j = 0; j < len; j++) {
			if(arr.get(j) != flag.getIcon())
				result.add(arr.get(j));
		}
		while(countBlank > 0) {
			result.add(flag.getIcon());
			countBlank--;
		}
		return result;
	}
	public ArrayList<Icon> moveRightAndDownReorder(ArrayList<Icon> arr) {
		int len = arr.size();
		JButton flag = new JButton(icons[0]);
		int countBlank = 0;
		for(int i = 0; i < len; i++) {
			if(arr.get(i) == flag.getIcon())
				countBlank++;
		}
		ArrayList<Icon> result = new ArrayList<Icon>();
		while(countBlank > 0) {
			result.add(flag.getIcon());
			countBlank--;
		}
		for(int j = 0; j < len; j++) {
			if(arr.get(j) != flag.getIcon())
				result.add(arr.get(j));
		}
		
		return result;
	}

	public boolean mergeCellToLeft() {
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COL - 1; j++) {
				if((cell[COL * i + j].getIcon() != icons[0]) && 
						(cell[COL * i + j].getIcon().toString() == cell[COL * i + j + 1].getIcon().toString())) {
					cell[COL * i + j].setIcon(icons[(int)(Math.log(getNumFromIcon(cell[COL * i + j].getIcon())) / Math.log(2)) + 1]);
					cell[COL * i + j + 1].setIcon(icons[0]);
					score += getNumFromIcon(cell[COL * i + j].getIcon());
					scoreLabel.setText(scoreHtmlFirst + score + scoreHtmlLast);
					if(hit2048(cell[COL * i + j].getIcon()))
						return true;
				}
			}
		}
		moveLeftHelper();
		return false;
	}
	public boolean mergeCellToRight() {
		for(int i = 0; i < ROW; i++) {
			for(int j = COL - 1; j > 0; j--) {
				if((cell[COL * i + j].getIcon() != icons[0]) && 
						(cell[COL * i + j].getIcon().toString() == cell[COL * i + j - 1].getIcon().toString())) {
					cell[COL * i + j].setIcon(icons[(int)(Math.log(getNumFromIcon(cell[COL * i + j].getIcon())) / Math.log(2)) + 1]);
					cell[COL * i + j - 1].setIcon(icons[0]);
					score += getNumFromIcon(cell[COL * i + j].getIcon());
					scoreLabel.setText(scoreHtmlFirst + score + scoreHtmlLast);
					if(hit2048(cell[COL * i + j].getIcon()))
						return true;
				}
			}
		}
		moveRightHelper();
		return false;
	}
	public boolean mergeCellToUp() {
		for(int i = 0; i < COL; i++) {
			for(int j = 0; j < ROW - 1; j++) {
				if((cell[ROW * j + i].getIcon() != icons[0]) && 
						(cell[ROW * j + i].getIcon().toString() == cell[ROW * (j + 1) + i].getIcon().toString())) {
					cell[ROW * j + i].setIcon(icons[(int)(Math.log(getNumFromIcon(cell[ROW * j + i].getIcon())) / Math.log(2)) + 1]);
					cell[ROW * (j + 1) + i].setIcon(icons[0]);
					score += getNumFromIcon(cell[ROW * j + i].getIcon());
					scoreLabel.setText(scoreHtmlFirst + score + scoreHtmlLast);
					if(hit2048(cell[ROW * j + i].getIcon()))
						return true;
				}
			}
		}
		moveUpHelper();
		return false;
	}
	public boolean mergeCellToDown() {
		for(int i = 0; i < COL; i++) {
			for(int j = ROW - 1; j > 0; j--) {
				if((cell[ROW * j + i].getIcon() != icons[0]) && 
						(cell[ROW * j + i].getIcon().toString() == cell[ROW * (j - 1) + i].getIcon().toString())) {
					cell[ROW * j + i].setIcon(icons[(int)(Math.log(getNumFromIcon(cell[ROW * j + i].getIcon())) / Math.log(2)) + 1]);
					cell[ROW * (j - 1) + i].setIcon(icons[0]);
					score += getNumFromIcon(cell[ROW * j + i].getIcon());
					scoreLabel.setText(scoreHtmlFirst + score + scoreHtmlLast);
					if(hit2048(cell[ROW * j + i].getIcon()))
						return true;
				}
			}
		}
		moveDownHelper();
		return false;
	}

	public boolean isGameOver() {
		for(int i = 0; i < ROW * COL; i++) {
			if(cell[i].getIcon() == icons[0])
				return false;
		}
		return !canMergeAny() && true;
	}
	
	public boolean hit2048(Icon icon) {
		if(icon == icons[11] && countHit2048 == 0){
			countHit2048++;
			int congInfo = JOptionPane.showConfirmDialog(frame, "Congratuations!\nYou're the winner!\nIf you want contunitue the game, please click \"OK\", or click \"Cancel\"", "Congratuations!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			
			if(congInfo == JOptionPane.CANCEL_OPTION) {
				initCells();
				startGame();
				return true;
			}
		}
		return false;
			
	}
	
	public boolean canMergeAny() {
		for(int i = 0; i < ROW; i++) {
			for(int j = 0; j < COL - 1; j++) {
				if(cell[COL * i + j].getIcon().toString() == cell[COL * i + j + 1].getIcon().toString())
					return true;
			}
		}
		for(int m = 0; m < COL; m++) {
			for(int n = 0; n < ROW - 1; n++) {
				if(cell[ROW * n + m].getIcon().toString() == cell[ROW * (n + 1) + m].getIcon().toString())
					return true;
			}
		}
		return false;
	}
	public void initCells() {
		score = 0;
		scoreLabel.setText(scoreHtmlFirst + score + scoreHtmlLast);
		countHit2048 = 0;
		rmBorder();
		for(int i = 0; i < ROW * COL; i++) {
			cell[i].setIcon(icons[0]);
		}
	}
	
	public void rmBorder() {
		for(int i = 0; i < ROW * COL; i++) {
			cell[i].setBorder(defaultBorder);
		}
	}
	
	public int getNumFromIcon(Icon icon) {
		String fileDir = icon.toString();
		String iconName = fileDir.substring(dirLen);
		int num = 0;
		
		for(int i = 0; i < iconName.length(); i++) {
			if((iconName.charAt(i) >= '0') && (iconName.charAt(i) <= '9')) {
				num = num * 10 + (iconName.charAt(i) - '0');
			}
		}
		return num;
	}
	
	public Icon setCellBlank(JButton bt) {
		Icon icon = bt.getIcon();
		bt.setIcon(icons[0]);
		return icon;
	}
	
	public boolean isEqual(JButton[] bt1, JButton[] bt2) {
		if(bt1.length != bt2.length)
			return false;
		for(int i = 0; i < bt1.length; i++) {
			if(bt1[i].getIcon() != bt2[i].getIcon())
				return false;
		}
		return true;
	}
}
