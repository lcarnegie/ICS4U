package com.bayviewglen.nQueens;

import java.util.Scanner;

public class nQueens {
	public static Stack qStack;
	public static int n;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean isValidInput = false;
		while (!isValidInput) {
			try {
				System.out.print("Type in a number: ");
				n = Integer.valueOf(in.nextLine());
				isValidInput = true;
			} catch (Exception e) {

			}
			qStack = new QueenArrayStack(n);
			qStack.push(new Queen(0, 0));
			boolean isBacktracking = false;
			for (int filled = 0; filled < n;) {
				if (filled == -1) { // only gets here if the first queen has been shifted until there is no room to
									// spare.
					System.out.println("There are no solutions.");
					return;
				} else if (checkForConflict(qStack.peek()) && !roomToSpare(qStack.peek(), n)) {
					filled--;
					qStack.pop();
					filled = backtrack(filled);
				} else if (checkForConflict(qStack.peek()) && roomToSpare(qStack.peek(), n)) {
					shiftQueen();
				} else if (!checkForConflict(qStack.peek())) {
					filled++;
					if (filled == n) {
					} else {
						qStack = addQueen(filled);
					}
				}
			}

		}
		printBoard(qStack);

	}

	private static int backtrack(int filled) {
		if (!checkForConflict(qStack.peek()) && roomToSpare(qStack.peek(), n)) {
			shiftQueen();
		} else {
			filled--;
			if (filled == -1) {
				return -1;
			} else {
				qStack.pop();
				filled = backtrack(filled);
			}
		}
		return filled;
	}

	private static Stack addQueen(int filled) {
		qStack.push(new Queen(0, filled));
		return qStack;
	}

	private static void shiftQueen() {
		qStack.peek().setxPos(qStack.peek().getxPos() + 1); // shifts queen one over in the x-axis

	}

	private static boolean checkForConflict(Queen curr) {
		Stack temp = qStack.clone();
		temp.pop(); // pops the current queen off of the stack
		boolean conflict = false;
		try {
			while (!conflict) {
				if (temp.peek().getxPos() == curr.getxPos() || Math.abs(temp.peek().getxPos() - curr.getxPos()) == Math
						.abs(temp.peek().getyPos() - curr.getyPos())) {
					conflict = true;
					return true;
				} else {
					temp.pop();
				}
			}
		} catch (Exception e) { // gets here if the temp has only one element left, so there should be no
								// conflict.
			conflict = false;
		}

		return false;
	}

	private static boolean roomToSpare(Queen queen, int n) {
		return (queen.getxPos() + 1 < n);
	}

	private static void printBoard(Stack qStack) {
		String[][] board = new String[n][n];
		while(!qStack.isEmpty()) {
			board[qStack.peek().getxPos()][qStack.peek().getyPos()] = qStack.pop().getSymbol(); 
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				try {
				if(board[i][j].equals("Q")) {
					System.out.print("Q ");
				}
				}catch(Exception e) {
					System.out.print("X "); 
				}
			}
			System.out.println();
		}

	}

}
