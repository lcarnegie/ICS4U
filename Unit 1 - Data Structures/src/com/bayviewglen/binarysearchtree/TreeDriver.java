package com.bayviewglen.binarysearchtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeDriver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("src/com/bayviewglen/binarysearchtree/tree.dat"));
		IntBST bst = new IntBST();
		while (in.hasNext()){
			bst.addInteger(in.nextInt());
		}
		
		bst.inOrderTraversal(); 
		bst.delete(5); 
		bst.balance(); 
		
		
		in.close();
	}
}
