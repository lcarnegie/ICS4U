package com.bayviewglen.stacks;

import java.util.Scanner;

public class nQueens {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack stack = new IntegerArrayStack();
		String[][] chessBoard;
		int nQueens = 0;
		try {
			System.out.print("Type in a number: ");
			String response = in.nextLine();
			nQueens = Integer.parseInt(response); // number of queens
			chessBoard = new String[Integer.parseInt(response)][Integer.parseInt(response)]; // creates an N x N board
		} catch (Exception e) {
			System.out.println("Salad");
		}
		

	}

}
