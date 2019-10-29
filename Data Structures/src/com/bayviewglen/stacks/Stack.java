package com.bayviewglen.stacks;

public interface Stack {

/*
 * Puts the element el on the top of the stack
 */
 public void push(Integer el);
 /*
  * takes the topmost element from the stack;
  */
 public Integer pop();
/*
 * returns the topmost element in the stack without removing it
 */
 public Integer peek();
 /*
  * Checks to see if the stack is empty;
  */
 public boolean isEmpty();
}
