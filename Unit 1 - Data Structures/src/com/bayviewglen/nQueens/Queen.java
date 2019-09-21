package com.bayviewglen.nQueens;

public class Queen {
	String symbol;
	int xPos;
	int yPos;

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
}
