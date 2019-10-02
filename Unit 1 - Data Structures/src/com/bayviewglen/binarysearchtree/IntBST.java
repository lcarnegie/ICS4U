package com.bayviewglen.binarysearchtree;

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

	public boolean delete(int searchTerm) {
		return delete(root, searchTerm);

	}

	private boolean delete(IntBinaryTreeNode root, int searchTerm) {
		if (root == null)
			return false;
		else if (root.getData() == searchTerm) {
			IntBinaryTreeNode temp = new IntBinaryTreeNode(0);
			temp.setLeft(root);
			boolean result = root.delete(searchTerm, temp);
			return result;
		} else {
			return root.delete(searchTerm, null);
		}
	}

	public void balance() {

	}

}
