package com.bayviewglen.nQueens;

import java.util.Scanner;

public class jj {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = 0;

		boolean isValidInput = false;
		while (!isValidInput) {
			try {
				System.out.print("Type in a number: ");
				n = Integer.parseInt(in.nextLine());
				isValidInput = true;
			} catch (Exception e) {

			}
		Stack qstack = new QueenArrayStack();
		Queen[][] board = new Queen[n][n]; 
		qstack.push(new Queen(0,0));
		for(int filled = 0; filled < n;) {
			if(checkConflicts()) {
				
			} else if(!checkConflicts() && roomToSpare()) {
				
			} else if(!checkConflicts() && !roomToSpare()) {
				filled--; 
			} 
			if(filled == -1) {
				System.out.println("There are no solutions");
			}
		}
		printBoard(board); 
		
		}
	}

	private static boolean roomToSpare() {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkConflicts() {
		// TODO Auto-generated method stub
		return false;
	}

	
}


