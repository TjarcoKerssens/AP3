package assignment3;

/**
 * @elements	:	Objects of type E
 * @structure 	:	None
 * @domain		:	All objects of type E (?)
 * @contructor	:	TreeNode(E d);
 * @param		:	d, data of type E, containing an Identifier
 * @precondition:	-
 * @postcondition:	A new TreeNode is created containing data of Type E, and no pointers
 * 					to either leftChild, rightChild or parent
 * 
 * @constructor	:	TreeNode(E d, TreeNode<E> leftChild, TreeNode<E> rightChild, TreeNode<E> parent);
 * @param		:	d, data of type E, containing an Identifier
 * @param		:	leftChild, the left child of this TreeNode
 * @param		:	rightChild, the right child of this TreeNode
 * @param		:	parent, the parent node of this TreeNode
 * @precondition:	-
 * @postcondition:	A new TreeNode is creating containing data of Type E, and pointers
 * 					to other TreeNodes, leftChild, rightChild and parent
 */

public interface TreeNodeInterface<E extends Data> extends Clonable {
	

}
