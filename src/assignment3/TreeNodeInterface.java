package assignment3;

/**
 * @elements	:	Objects of type E
 * @structure 	:	None
 * @domain		:	All objects of type E (?)
 * @contructor	:	TreeNode(E d);
 * @param		:	d, data of type E, containing an Identifier
 * @precondition:	-
 * @postcondition:	A new TreeNode is created containing data of Type E, and no pointers
 * 					to either leftChild or rightChild
 * 
 * @constructor	:	TreeNode(E d, TreeNode<E> leftChild, TreeNode<E>, rightChild);
 * @param		:	d, data of type E, containing an Identifier
 * @param		:	leftChild, the left child of this TreeNode
 * @param		:	rightChild, the right child of this TreeNode
 * @precondition:	-
 * @postcondition:	A new TreeNode is creating containing data of Type E, and pointers
 * 					to other TreeNodes, leftChild and RightChild
 */

public interface TreeNodeInterface<E extends Data> extends Clonable {
	

}
