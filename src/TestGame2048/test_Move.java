package TestGame2048;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/*
 * Cannot run, just used to record "moveLeft", "moveRight", "moveUp" and "moveDown" methods
 */
public class test_Move {
	int ROW = 4;
	int COL = 4;
	
	ImageIcon icon_blank;
	
	JButton[] cell = new JButton[ROW * COL];
	
	public void moveLeft() {
		JButton[] temp = new JButton[ROW * COL];
		temp = cell;
		for(int i = 0; i < COL; i++) {
			
			cell[i].setIcon(i + 1 >= COL ? icon_blank : temp[i + 1].getIcon());
			cell[COL + i].setIcon(COL + i + 1 >= COL * 2 ? icon_blank : temp[COL + i + 1].getIcon());
			cell[COL * 2 + i].setIcon(COL * 2 + i + 1 >= COL * 3 ? icon_blank : temp[COL * 2 + i + 1].getIcon());
			cell[COL * 3 + i].setIcon(COL * 3 + i + 1 >= COL * 4 ? icon_blank : temp[COL * 3 + i + 1].getIcon());
		}
		
//		for(int i = 0; i < COL; i++) {
//		for(int j = 0; j < ROW; j++) {
//			if(
//				(cell[COL * j + i].getIcon() != icon_blank && i == 0) || 
//				(i > 0 && cell[COL * j + i].getIcon() != icon_blank && cell[COL * j + i - 1].getIcon() != icon_blank))
//			{
//				// do nothing!
//			}
//			else{
//				cell[COL * j + i].setIcon(COL * j + i + 1 >= COL * (j + 1) ? icon_blank : setCellBlank(cell[COL * j + i + 1]));
//			}
//		}
//	}
	}
	
	public void moveRight() {
		JButton[] temp = new JButton[ROW * COL];
		temp = cell;
		for(int i = COL - 1; i >= 0; i--) {
			
			cell[i].setIcon(i - 1 < 0 ? icon_blank : temp[i - 1].getIcon());
			cell[COL + i].setIcon(COL + i - 1 < COL ? icon_blank : temp[COL + i - 1].getIcon());
			cell[COL * 2 + i].setIcon(COL * 2 + i - 1 < COL * 2 ? icon_blank : temp[COL * 2 + i - 1].getIcon());
			cell[COL * 3 + i].setIcon(COL * 3 + i - 1 < COL * 3 ? icon_blank : temp[COL * 3 + i - 1].getIcon());
		}
		
//		for(int i = COL - 1; i >= 0; i--) {
//		for(int j = 0; j < ROW; j++)
//			if((cell[COL * j + i].getIcon() != icon_blank && i == COL - 1) ||
//				(i < COL - 1 && cell[COL * j + i].getIcon() != icon_blank && cell[COL * j + i + 1].getIcon() != icon_blank)) {
//				// do nothing
//			}
//			else {
//			cell[COL * j + i].setIcon(COL * j + i - 1 < COL * j ? icon_blank : setCellBlank(cell[COL * j + i - 1]));
//			}
//	}
	}
	
	public void moveUp() {
		JButton[] temp = new JButton[ROW * COL];
		temp = cell;
		for(int i = 0; i < ROW; i++) {
			
			cell[COL * i].setIcon(i == ROW - 1 ? icon_blank : temp[COL * (i + 1)].getIcon());
			cell[COL * i + 1].setIcon(i == ROW - 1 ? icon_blank : temp[COL * (i + 1) + 1].getIcon());
			cell[COL * i + 2].setIcon(i == ROW - 1 ? icon_blank : temp[COL * (i + 1) + 2].getIcon());
			cell[COL * i + 3].setIcon(i == ROW - 1 ? icon_blank : temp[COL * (i + 1) + 3].getIcon());
			
		}
		
//		for(int i = 0; i < ROW; i++) {
//		for(int j = 0; j < COL; j++)
//			if((cell[COL * i + j].getIcon() != icon_blank && i == 0) || 
//				(i > 0 && cell[COL * i + j].getIcon() != icon_blank && cell[COL * (i - 1) + j].getIcon() != icon_blank)) {
//				// do nothing
//			}
//			else {
//				cell[COL * i + j].setIcon(i == ROW - 1 ? icon_blank : setCellBlank(cell[COL * (i + 1) + j]));
//			}			
//	}
	}
	
	public void moveDown() {
		JButton[] temp = new JButton[ROW * COL];
		temp = cell;
		for(int i = ROW - 1; i >= 0; i--) {
			
			cell[COL * i].setIcon(i == 0 ? icon_blank : temp[COL * (i - 1)].getIcon());
			cell[COL * i + 1].setIcon(i == 0 ? icon_blank : temp[COL * (i - 1) + 1].getIcon());
			cell[COL * i + 2].setIcon(i == 0 ? icon_blank : temp[COL * (i - 1) + 2].getIcon());
			cell[COL * i + 3].setIcon(i == 0 ? icon_blank : temp[COL * (i - 1) + 3].getIcon());
			
		}
		
//		for(int i = ROW - 1; i >= 0; i--) {
//		for(int j = 0; j < COL; j++)
//			if((cell[COL * i + j].getIcon() != icon_blank && i == ROW - 1) || 
//					(i < ROW - 1 && cell[COL * i + j].getIcon() != icon_blank && cell[COL * (i + 1) + j].getIcon() != icon_blank)) {
//				// do nothing
//			}
//			else {
//				cell[COL * i + j].setIcon(i == 0 ? icon_blank : setCellBlank(cell[COL * (i - 1) + j]));
//			}			
//	}
	}
}
