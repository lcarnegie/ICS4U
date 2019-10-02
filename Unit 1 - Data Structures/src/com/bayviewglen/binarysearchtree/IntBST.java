package com.bayviewglen.binarysearchtree;

public class IntBST {
	private IntBinaryTreeNode root;
	
	public IntBST() {
		root = null;
	}
	
	public void addInteger(int data){
		if (root == null)
			root = new IntBinaryTreeNode(data);
		else
			addInteger(root, data);
	}

	private void addInteger(IntBinaryTreeNode node, int data) {
		if (data < node.getData()){
			if (node.hasLeft())
				addInteger(node.getLeft(), data);
			else
				node.setLeft(new IntBinaryTreeNode(data));
		}else{
			if (node.hasRight())
				addInteger(node.getRight(), data);
			else
				node.setRight(new IntBinaryTreeNode(data));
		}
	}
	
	public void processNode(IntBinaryTreeNode node){
		System.out.println(node.getData());
	}
	
	
	public void preOrderTraversal(){
		preOrderTraversal(root);
	}

	private void preOrderTraversal(IntBinaryTreeNode node) {
		processNode(node);
		if (node.hasLeft())
			preOrderTraversal(node.getLeft());
		if (node.hasRight())
			preOrderTraversal(node.getRight());	
	}
	
	public void postOrderTraversal(){
		postOrderTraversal(root);
	}

	private void postOrderTraversal(IntBinaryTreeNode node) {
		
		if (node.hasLeft())
			postOrderTraversal(node.getLeft());
		if (node.hasRight())
			postOrderTraversal(node.getRight());
		
		processNode(node);
	}
	
	public void inOrderTraversal(){
		inOrderTraversal(root);
	}

	private void inOrderTraversal(IntBinaryTreeNode node) {
		if (node.hasLeft())
			inOrderTraversal(node.getLeft());
		processNode(node);
		if (node.hasRight())
			inOrderTraversal(node.getRight());	
	}
	
	public int search(int searchTerm) {
		return search(root,searchTerm); 
	}
	
	private int search(IntBinaryTreeNode node, int searchTerm) {
		int result = 0; 
		if(node.getData() == searchTerm) {
			return node.getData(); 
		}if (node.hasLeft()) {
			result = search(node.getLeft(), searchTerm); 
		}if(result != searchTerm && node.hasRight()) {
			result = search(node.getRight(), searchTerm); 
		}else {
			result = -1; 
		}
		return result; 
	}
	
	public void delete(int searchTerm) {
		
	}
	
	public void balance() {
		
	}
	
}
