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
				if(n < 0)
					n *= -1; 
				isValidInput = true;
			} catch (Exception e) {

			}
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

		printBoard(qStack);

	}
	
	/* Backtrack: 
	 * 
	 * This method is called when a Queen has a conflict, but has no more space to move on the x-axis 
	 * (i.e when the Queen's x-position = n-1). Before the method is called, the Queen that caused the 
	 * backtracking is popped from the stack, and filled (the controller variable for the columns) 
	 * is reduced by 1, which is then passed into the method. The method then checks if the queen in 
	 * the previous row has no conflicts and a space to move into -> if the previous Queen does have space, 
	 * it shifts over a space in the x-axis. If there is no room for the Queen to move, the stack is popped
	 * and the method calls itself until it finds a Queen that can move over, or the method returns -1, 
	 * indicating that there is no solution to that particular board size. 
	 * 
	 */

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
	
	/* Shift Queen:
	 *
	 *When called, this method shifts a Queen over one row. 
	 * 
	 */
	
	private static void shiftQueen() {
		qStack.peek().setxPos(qStack.peek().getxPos() + 1); // shifts queen one over in the x-axis
	
	}

	/* Add:
	 * 
	 * This method adds a Queen to the stack at (0, filled). Filled is the controller variable 
	 * for the current column the algorithm is working on. 
	 * 
	 */
	
	private static Stack addQueen(int filled) {
		qStack.push(new Queen(0, filled));
		return qStack;
	}
	
	/* Check for Conflict:
	 * 
	 * This method checks for conflicts between the topmost (current) Queen in the stack and the 
	 * other Queens. It works by copying the current state of the stack to a new Stack object, so 
	 * that operations can be performed on it, rather than possibly losing the data stored in the 
	 * original stack object. It pops the top of the copied stack, to remove the current Queen. 
	 * It then enters a for loop, checking whether each queen placed before it is either below it 
	 * (by comparing y-values), or on a diagonal with it (by comparing the difference between the x-
	 * and y-values of the two Queens being compared). If there if a conflict, the method returns true, 
	 * otherwise it returns false. 
	 * 
	 */

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
	
	/*Room to Spare:
	 * 
	 * This method checks whether a Queen object has space to move over in the x-axis. It does so by checking 
	 * whether the the current Queen's x-position plus one (the desired position) equals n. If a queen's x-position
	 * was equal to n, it would be out of the bounds of the chess board. 
	 * 
	 */

	private static boolean roomToSpare(Queen queen, int n) {
		return (queen.getxPos() + 1 < n);
	}
	
	/*Print Board:
	 * 
	 * This method prints the solution to the console. It first places every Queen by popping the stack and 
	 * retrieving each Queen's unique x- and y-value. It then fills the rest of the spaces between the Queens
	 * with an "X". 
	 * 
	 */

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
