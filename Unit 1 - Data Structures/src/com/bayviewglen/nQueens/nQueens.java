package com.bayviewglen.nQueens;

import java.util.Scanner;

public class nQueens {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack stack = new QueenArrayStack();
		Queen[][] chessBoard;
		int n = 0;
		int filled; 
		System.out.print("Type in a number: ");
		String response = in.nextLine();
		n = Integer.parseInt(response); // number of queens
		chessBoard = new Queen[Integer.parseInt(response)][Integer.parseInt(response)]; // creates an N x N board
		stack.push(new Queen(0,0));
		chessBoard[0][0] = stack.peek();   
		for(filled = 1; filled < n;) {
			stack.push(new Queen(0, filled));
			chessBoard[0][filled] = stack.peek();// @TODO Look at this
			 if(noConflict()) {
				 filled++; 
			 } else if(!noConflict() && roomToShift()) {
				 
			 } else if(!noConflict() && !roomToShift()) {
				 
			 }
		}
		
		
	}

	private static boolean noConflict() {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean roomToShift() {
		// TODO Auto-generated method stub
		return false;
	}

}
