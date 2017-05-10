
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class ChessBoard extends JPanel {
	
	public static void main(String[]args){
		ChessBoard mainBoard = new ChessBoard();
		mainBoard.logic();
		mainBoard.movePiece(0,0,1,1);
		mainBoard.displayBoard();
		//System.out.print(mainBoard.board[0][0]);
		//mainBoard.draw();
	}

	char[][] board;

	/*public void paint (Graphics g){
		g.setFont(g.getFont().deriveFont(48f));
		g.fillRect(100, 100, 400, 400);
		for (int i = 100 ; i <= 400 ; i+=100){
			for (int j = 100 ; j <= 400 ; j += 100){
				g.clearRect(i, j, 50, 50);
			}
		}

		for (int i = 150 ; i <= 450 ; i += 100){
			for (int j = 150 ; j <= 450 ; j += 100){
				g.clearRect(i, j, 50, 50);
			}
		}
		for (int ii = 0; ii < 8; ii++){
			for (int jj = 0; jj < 8; jj++){
				//g.drawString("X",ii*50+101,jj*50+140);
				//System.out.println(((Character) board[ii][jj]).toString());
				g.drawString(((Character) board[ii][jj]).toString(), ii*50 + 101, jj * 50 + 140);
			}
		}
	}*/

	public ChessBoard(){
		this.board = new char[8][8];
	}

	public void logic(){
		for(int ii = 0; ii < 8; ii++){
			for (int jj = 0; jj < 8; jj++){
				this.board[ii][jj] = '\u2003';
			}
		}
		String piecePosition = "b.rk:a8 , b.kt:b8 , b.bs:c8 , b.qn:d8 , b.kg:e8 , b.bs:f8 , b.kt:g8 , b.rk:h8 , "
				+ "b.pn:a7 , b.pn:b7 , b.pn:c7 , b.pn:d7 , b.pn:e7 , b.pn:f7 , b.pn:g7 , b.pn:h7 , "
				+ "w.rk:a1 , w.kt:b1 , w.bs:c1 , w.qn:d1 , w.kg:e1 , w.bs:f1 , w.kt:g1 , w.rk:h1 , "
				+ "w.pn:a2 , w.pn:b2 , w.pn:c2 , w.pn:d2 , w.pn:e2 , w.pn:f2 , w.pn:g2 , w.pn:h2";
		String[] pieces = piecePosition.split(" , ");
		 for(int i=0 ; i < pieces.length ; i++){
			 placePiece(pieces[i], this.board);
		 }
		 displayBoard();
	}
	
	public void displayBoard(){
		for(int ii = 0; ii < 8; ii++){
			 for(int jj = 0; jj < 8; jj++){
				 System.out.print(this.board[ii][jj]);
			 }
			 System.out.println("");
		 }
	}
/*
	public void draw(){
			JFrame frame = new JFrame();
			frame.setSize(600,600);
			frame.getContentPane().add(new ChessBoard());
			frame.setLocationRelativeTo(null);
			frame.setBackground(Color.lightGray);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.repaint();
			frame.setVisible(true);
			frame.repaint();

			frame.repaint();
	}
*/
	public static void placePiece(String s, char[][] c){
		String[] piece = s.split(":");

		char symbol = ' ';
		switch(piece [0]){
		case "b.rk": symbol = '\u265c';
		break;
		case "b.kt": symbol = '\u265e';
		break;
		case "b.bs": symbol = '\u265d';
		break;
		case "b.qn": symbol = '\u265b';
		break;
		case "b.kg": symbol = '\u265a';
		break;
		case "b.pn": symbol = '\u265f';
		break;
		case "w.rk": symbol = '\u2656';
		break;
		case "w.kt": symbol = '\u2658';
		break;
		case "w.bs": symbol = '\u2657';
		break;
		case "w.qn": symbol = '\u2655';
		break;
		case "w.kg": symbol = '\u2654';
		break;
		case "w.pn": symbol = '\u2659';
		break;
		}
		int xCoord;
		switch(piece[1].charAt(0)){
		case 'a' :	xCoord = 7;
					break;
		case 'b' :	xCoord = 6;
					break;
		case 'c' :	xCoord = 5;
					break;
		case 'd' :	xCoord = 4;
					break;
		case 'e' :	xCoord = 3;
					break;
		case 'f' :	xCoord = 2;
					break;
		case 'g' :	xCoord = 1;
					break;
		case 'h' :	xCoord = 0;
					break;
		default : 	xCoord = 0;
		}
		int yCoord = 8+(-1*Integer.parseInt(piece[1].substring(1)));
		c[yCoord][xCoord] = symbol;
	}
	
	public void movePiece(int x1, int y1, int x2, int y2){
		this.board[x2][y2] = this.board[x1][y1];
		this.board[x1][y1] = '\u2003';
	}
}
