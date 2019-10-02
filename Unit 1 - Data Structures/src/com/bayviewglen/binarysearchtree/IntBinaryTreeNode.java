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

	public boolean delete(int searchTerm, IntBinaryTreeNode parent) {
		if(searchTerm < this.getData()) {
			if(this.getLeft() != null)
				return this.getLeft().delete(searchTerm, this); 
			else
				return false; 
		}else if(searchTerm > this.getData()) {
			if(this.getRight() != null)
				return this.getRight().delete(searchTerm, this); 
			else
				return false; 
		} else {
			if(this.getLeft() != null && this.getRight() != null) {
				this.setData(getMinValue(this.getRight()));
				this.getRight().delete(this.getData(), this); 
			}else if(parent.getLeft() == this) {
				parent.setLeft(this.getLeft());
			}else if(parent.getRight() == this) {
				parent.setRight(this.getRight());
			}
			return true; 
		}
	}

	private int getMinValue(IntBinaryTreeNode n) {
		if(!n.hasLeft())
			return n.getData(); 
		else
			return n.getMinValue(n.getLeft()); 
	}

	
	
	
}

