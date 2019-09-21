package com.bayviewglen.nQueens;

import java.util.Scanner;


public class nQueens {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;

		boolean isValidInput = false;
		while (!isValidInput) {
			try {
				System.out.print("Type in a number: ");
				n = Integer.valueOf(in.nextLine());
				isValidInput = true;
			} catch (Exception e) {

			}
		Stack qstack = new QueenArrayStack();
		Queen[][] board = new Queen[n][n]; 
		qstack.push(new Queen(0,0));
		board[0][0] = qstack.peek(); 
		boolean isBacktracking = false; 
		for(int filled = 0; filled < n;) {
			if(filled == -1) {
				System.out.println("There are no solutions.");
				return; 
			}else if(!noConflict(qstack.peek().getxPos(), qstack.peek().getyPos(), n, board) && !roomToSpare(qstack.peek().getxPos(), n)) {
				isBacktracking = true; 
				board[qstack.peek().getxPos()][qstack.peek().getxPos()] = null; 
				qstack.pop(); 
				filled--; 
			}else if(!noConflict(qstack.peek().getxPos(), qstack.peek().getyPos(), n, board) && roomToSpare(qstack.peek().getxPos(), n)) {
				board[qstack.peek().getxPos()][qstack.peek().getyPos()] = null; 
				int newX = qstack.peek().getxPos() + 1, newY = qstack.peek().getyPos(); 
				if(newX == n) {
				}else {
				board[newX][newY] = new Queen(newX, newY);
				qstack.peek().setxPos(newX);
				qstack.peek().setyPos(newY); 
				}
			} else if(isBacktracking && noConflict(qstack.peek().getxPos(), qstack.peek().getyPos(), n, board) && roomToSpare(qstack.peek().getxPos(), n)) { // should only get here if backtracking
				board[qstack.peek().getxPos()][qstack.peek().getxPos()] = null; 
				int newX = qstack.peek().getxPos() + 1, newY = qstack.peek().getxPos() + 1; 
				if(newX == 4) {
					
				}else {
				board[newX][newY] = new Queen(newX, newY);
				qstack.peek().setxPos(newX);
				qstack.peek().setyPos(newY); 
				}
			}else if(noConflict(qstack.peek().getxPos(), qstack.peek().getyPos(), n, board)) {
				isBacktracking = false;
				filled++;  
				if(filled == n) {
				}else {
					qstack.push(new Queen(0, filled));
					board[0][filled] = qstack.peek(); 
				}
				
			} 
		}
		printBoard(board); 
		
		}

	}

	private static boolean isBacktracking() {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean noConflict(int xPos, int yPos, int n, Queen[][] board) {
		for (int y = yPos - 1, x = xPos; y > -1; y--) { // checks directly below
			try {
				if (board[xPos][y].equals(new Queen(x, y))) {
					return false;
				}
			} catch (Exception e) {
			}

		}

		for (int y = yPos - 1, x = xPos + 1; x < n && y > -1; x++, y--) { // checks for conflict on diagonal heading to
																			// [0][n]
			try {
				if (board[x][y].equals(new Queen(x, y))) {
					return false;
				}
			} catch (Exception e) {
			}

		}
		for (int y = yPos - 1, x = xPos - 1; x > -1 && y > -1; x--, y--) {// checks for conflict on diagonal heading to
																			// [0][0]
			try {
				if (board[x][y].equals(new Queen(x, y))) {
					return false;
				}
			} catch (Exception e) {
			}
		}

		return true;
	}

	private static boolean roomToSpare(int xPos, int n) {
		return (xPos <= n);
	}
	
	private static void printBoard(Queen[][] board) {
		String[][] stringBoard = new String[board.length][board[0].length]; 
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				try {
					if(board[i][j].equals(new Queen(i,j))) {
						stringBoard[i][j] = board[i][j].getSymbol(); 
					}
				} catch(Exception e) {
					stringBoard[i][j] = "X"; 
				}
				System.out.print(stringBoard[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
