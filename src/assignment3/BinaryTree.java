package assignment3;

import java.util.Iterator;

public class BinaryTree<E extends Data> implements BinaryTreeInterface<E> {

	protected TreeNode<E> list;

	@Override
	public BinaryTree<E> init() {
		list = null;
		return this;
	}

	@Override
	public BinaryTree<E> insert(E d) {
		list = insert(list, d);
		return this;
	}

	private TreeNode<E> insert(TreeNode<E> root, E d) {
		if (root == null) {
			root =  new TreeNode<E>(d);
		}
		else if (root.data.compareTo(d) == 0) {
			remove(d);
		}
		else if (root.data.compareTo(d)>0) {
			root.leftChild = insert(root.leftChild, d);
		}else{
			root.rightChild = insert(root.rightChild, d);
		}
		return root;
	}
	
	@Override
	public BinaryTree<E> remove(E d) {
		list = remove(list, d);		
		return this;
	}	
	
	private TreeNode<E> remove(TreeNode<E> root, E d) {

		if( d.compareTo(root.data) < 0) {
			root.leftChild = remove( root.leftChild, d);
		} else if ( d.compareTo(root.data) > 0) {
			root.rightChild= remove( root.rightChild, d);
		} else if (root.leftChild != null && root.rightChild != null) {
			root.data = findSmallest(root.rightChild).data;
			root.rightChild = remove(root.rightChild, root.data);
		} else {
			root = (root.leftChild != null) ? root.leftChild : root.rightChild;
		}
		return root;
	}
	

	private TreeNode<E> findSmallest(TreeNode<E> node){
		while(node.leftChild!=null){
			node = node.leftChild;
		}
		return node;
 	}

	public TreeNode<E> getList() {
		return list;
	}

	public E retrieve() {
		return list.data;
	}

	@Override
	public boolean contains(E d) {
		return contains(list, d);
	}
	
	private boolean contains(TreeNode<E> root, E d) {
		
		if (root == null) {
			return false;
		}
		else if (root.data.compareTo(d) == 0) {
			return true;
		} 
		else if (root.data.compareTo(d) > 0) {
			return contains(root.leftChild, d);
		} 
		else {
			return contains(root.rightChild, d);
		}
	}

	@Override
	public int size() {
		int counter = 1;
		return size(list, counter);
	}
	
	private int size(TreeNode<E> root, int counter) {
		if (root == null) {
			return 0;
		}
		return counter + size(root.leftChild, counter) + size(root.rightChild, counter);
	}

	@Override
	public boolean isEmpty() {
		return list == null;
	}

	@Override
	public Iterator ascendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator descendingIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public  void inOrderTreeWalk(TreeNode<E> x) {
		if (x != null) {
			inOrderTreeWalk(x.leftChild);
			System.out.print(x.data);
			inOrderTreeWalk(x.rightChild);
		}
		
	}
	
	private TreeNode<E> clone(TreeNode<E> root) {
		
		BinaryTree<E> clone = new BinaryTree<E>();

		if (root != null) {
			clone(root.leftChild);
			clone.insert(root.data);
			clone(root.rightChild);
		}
		return root;
	}

	public BinaryTree<E> clone() {
		BinaryTree<E> clone = new BinaryTree<E>();
		clone.list = clone(getList());
		return clone;
	}

}
