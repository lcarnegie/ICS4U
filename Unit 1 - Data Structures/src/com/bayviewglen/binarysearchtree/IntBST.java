package com.bayviewglen.binarysearchtree;

import java.util.ArrayList;

public class IntBST {
	private IntBinaryTreeNode root;

	public IntBST() {
		root = null;
	}

	public void addInteger(int data) {
		if (root == null) {
			root = new IntBinaryTreeNode(data);
		} else {
			addInteger(root, data);
		}
	}

	private void addInteger(IntBinaryTreeNode node, int data) {
		if (data < node.getData()) {
			if (node.hasLeft()) {
				addInteger(node.getLeft(), data);

			} else {
				node.setLeft(new IntBinaryTreeNode(data));

			}
		} else {
			if (node.hasRight()) {
				addInteger(node.getRight(), data);

			} else {
				node.setRight(new IntBinaryTreeNode(data));

			}
		}
	}

	public void processNode(IntBinaryTreeNode node) {
		System.out.println(node.getData());
	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(IntBinaryTreeNode node) {
		processNode(node);
		if (node.hasLeft())
			preOrderTraversal(node.getLeft());
		if (node.hasRight())
			preOrderTraversal(node.getRight());
	}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(IntBinaryTreeNode node) {

		if (node.hasLeft())
			postOrderTraversal(node.getLeft());
		if (node.hasRight())
			postOrderTraversal(node.getRight());

		processNode(node);
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(IntBinaryTreeNode node) {
		if (node.hasLeft())
			inOrderTraversal(node.getLeft());
		processNode(node);
		if (node.hasRight())
			inOrderTraversal(node.getRight());
	}

	public IntBinaryTreeNode search(int searchTerm) {
		return search(root, searchTerm);
	}

	private IntBinaryTreeNode search(IntBinaryTreeNode node, int searchTerm) {
		IntBinaryTreeNode result = null;
		if (node.getData() == searchTerm) {
			return node;
		} else if (searchTerm < node.getData()) {
			if (!node.hasLeft()) {
				return null;
			} else {
				result = search(node.getLeft(), searchTerm);
			}
		} else {
			if (!node.hasRight()) {
				return null;
			} else {
				result = search(node.getRight(), searchTerm);
			}
		}

		return result;
	}

	public IntBinaryTreeNode delete(int data) {
		return delete(root, data);

	}

	private IntBinaryTreeNode delete(IntBinaryTreeNode root, int data) {
		if (root == null)
			return root;
		if(data < root.getData()) {
			root.setLeft(delete(root.getLeft(), data));
		}else if(data > root.getData()) {
			root.setRight(delete(root.getRight(), data));
		} else {
			if(!root.hasLeft() && !root.hasRight()) {
				//node with no children
				return null; //getting rid of the reference to the thing to be deleted
			}else if(!root.hasLeft()) {
				//node with only a right child
				return root.getRight(); // you are setting the reference past the thing you want to delete, and to its right child 
			}else if(!root.hasRight()) {
				//node with only a left child
				return root.getLeft(); 
			}else {
				//node with TWO children
				Integer minVal = getMinValue(root.getRight()); // find the lowest value in the root's right subtree
				root.setData(minVal);//set the root's value to the min value
				root.setRight(delete(root.getRight(), minVal)); // remove the min value from the subtree (already exists as the new root.)
			}
		}
		return root; //return the changed tree 
	}
	
	private int getMinValue(IntBinaryTreeNode n) {//just keep going left until you can't go left anymore 
		if(!n.hasLeft())						  //that value IS your min value. 
			return n.getData(); 
		else
			return getMinValue(n.getLeft()); 
	}

	public IntBinaryTreeNode balance() { // A BALANCED BST IS ONE WHERE ALL THE ROWS ARE FULL (I.E. all the nodes have children, except the bottom row)
		ArrayList<IntBinaryTreeNode> nodes = new ArrayList(); 
		storeNodes(root, nodes); 
		
		int n = nodes.size(); 
		root = buildBalancedTree(nodes, 0, n-1); 
		return root; 
		
	}
	
	private IntBinaryTreeNode buildBalancedTree(ArrayList<IntBinaryTreeNode> nodes, int start, int end) {
		//base case
		if(start > end)
			return null; 
		
		/*Get the middle element, and make it root*/ 
		int mid = (start + end) / 2; 
		IntBinaryTreeNode node = nodes.get(mid); 
		
		/*Similar to binary search, just all the method again for the left and right subtree*/
		node.setLeft(buildBalancedTree(nodes, start, mid - 1)); // you know these will be less than mid
		node.setRight(buildBalancedTree(nodes, mid + 1, end)); // you know these will be bigger than mid
		
		return node; //return the balanced tree
		
	}

	public void storeNodes(IntBinaryTreeNode root, ArrayList<IntBinaryTreeNode> nodes) {
		//base case
		if(root == null)
			return; 
		//store the nodes in order (it is sorted since it traverse 
		//from left to right, so no need to sort)
		storeNodes(root.getLeft(), nodes); 
		nodes.add(root); 
		storeNodes(root.getRight(), nodes); 
	}

}
