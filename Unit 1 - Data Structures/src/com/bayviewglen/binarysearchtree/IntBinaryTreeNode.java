package com.bayviewglen.binarysearchtree;

public class IntBinaryTreeNode {
	private int data;
	private IntBinaryTreeNode leftChild;
	private IntBinaryTreeNode rightChild;
	
	public IntBinaryTreeNode(int data, IntBinaryTreeNode leftChild, IntBinaryTreeNode rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public IntBinaryTreeNode(int data) {
		super();
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public boolean hasLeft(){
		return leftChild != null;
	}
	
	public boolean hasRight(){
		return rightChild != null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public IntBinaryTreeNode getLeft() {
		return leftChild;
	}
	public void setLeft(IntBinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public IntBinaryTreeNode getRight() {
		return rightChild;
	}
	public void setRight(IntBinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	
	
	
}

