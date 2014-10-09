package assignment3;

import java.util.Iterator;


/**
 *	@elements	:	Objects of type E
 *	@structure	:	Linear
 *	@domain		:	All elements of type E
 *
 *	@constructor:	BinaryTree();
 *	@precondition:	-
 *	@postcondition:	The new BinaryTree-object is an empty tree
 *
 */

public interface BinaryTreeInterface<E extends Data> {
	
	/**
	 * Initialize this BinaryTree object as an empty tree
	 * 
	 * @precondition	:	-
	 * @postcondition	:	An empty BinaryTree object has been returned
	 */
	BinaryTree<E> init();
	
	/**
	 * Add an element to the BinaryTree with the correct pointers for
	 * left child, right child and it's parent node, current is set to
	 * this element
	 * 
	 * @param 			:	e, the element to be added
	 * @return 			:	This binary tree
	 * @precondition	:	Element e is not null
	 * @postcondition	:	Element e is added to this BinaryTree, current points at e
	 */
	BinaryTree<E> insert(E d);
	
	/**
	 * Remove this element current points to in this BinaryTree and 
	 * set the correct pointers for the adjacent elements in this BinaryTree
	 * 
	 * @precondition	:	-
	 * @postcondition	:	The element current pointed to is removed from the BinaryTree
	 * 						Current points to	:	
	 * 						if the BinaryTree is now Empty, null
	 * 						if the BinaryTree is not empty and E was the right Child:
	 * 									current points to left child of previous parent node
	 * 						if the BinaryTree is not empty and E was the left child:
	 * 									current point to parent node
	 */
	BinaryTree<E> remove();
	
	
	/**
	 * Set current to the top element of the BinaryTree
	 * 
	 * @precondition 	:	-
	 * @postcondition	:	true	:	Current points to the first/top element
	 * 						false	:	BinaryTree is empty
	 */
	boolean setFirst();
	
	/**
	 * Search the BinaryTree for an element containing the parameters data,
	 * current points to corresponding element if found
	 * 
	 * @param			:	Data contained by the element
	 * 
	 * @precondition	:	-
	 * @postcondition	:	true	:	BinaryTree contains an element equal to d
	 * 									current points to the first element in the tree
	 * 									that is equal to d
	 * 						false	:	BinaryTree does not contain a similar element
	 * 									if BinaryTree is empty, current points to null
	 * 									if BinaryTree is not empty, current point to the last child
	 */
	boolean contains(E d);
	
	/**
	 * Return the BinaryTree size (number of elements in the BinaryTree) as an integer
	 * 
	 * @precondition	:	-
	 * @postcondition	:	The number of elements in this BinaryTree has been returned
	 */
	int size();
	
	/**
	 * Boolean to check whether the BinaryTree is empty or not
	 * 
	 * @precondition	:	-
	 * @postcondition	:	true	:	BinaryTree is empty
	 * 						false	:	BinaryTree is not empty
	 */
	boolean isEmpty();
	
	/** 
	 * @postcondition 	:	The data stored in the binary search tree was iterated in 
	 *						monotonically non-decreasing order and was added in this 
	 * 						order to an object of the type Iterator. 
	 * 						This object of the type Iterator was subsequently returned. 
	 **/ 
	 Iterator<E> ascendingIterator (); 
	 
	 /** 
	 * @postcondition	:	The data stored in the binary search tree was iterated 
	 *						in monotonically non-increasing order and was added in 
	 *						this order to an object of the type Iterator. 
	 *						This object of the type Iterator was subsequently returned. 
	 **/ 
	 Iterator<E> descendingIterator ();
	
	/**
	 * Clone/deep-copy this BinaryTree
	 * 
	 * @precondition		:	-
	 * @postcondition	:	A deep-copy if this BinaryTree has been returned
	 */
	BinaryTree<E> clone ();
	
	
}
