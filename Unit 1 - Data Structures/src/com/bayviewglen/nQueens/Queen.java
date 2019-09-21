package com.bayviewglen.nQueens;

public class Queen {
	private String symbol;
	

	private int xPos;
	private int yPos;
	
	public Queen() {
		this.symbol = "Q";
	}

	public Queen(int xPos, int yPos) {
		this.symbol = "Q";
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	/*
	 	* Checks if two Queen objects are equal by checking their x- and y-positions
	 	* 
	 	* If their x- and y-positions are equal, then the two Queen objects are considered to be equals
	 	* 
	 	* Otherwise, they are not equal
	 */
	
	public boolean equals(Queen q) {
		return (xPos == q.xPos && yPos == q.yPos); 
	}
}
