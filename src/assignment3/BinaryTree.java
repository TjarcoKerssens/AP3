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
		else if (root.data.compareTo(d)>0) {
			root.leftChild = insert(root.leftChild, d);
		}else{
			root.rightChild = insert(root.rightChild, d);
		}
		return root;
	}

	@Override
	public BinaryTree<E> remove(E d) {
				
		TreeNode<E> root = getNode(getList(), d);
		TreeNode<E> smallest = findSmallest(root);
		
		if (root.leftChild == null) {
			replaceSubTree(root, root.rightChild, root.data);
		} else if (root.rightChild == null) {
			replaceSubTree(root, root.leftChild, root.data);
		} else {
			if (getParent(getList(), smallest.data) != root) {
				replaceSubTree(smallest, smallest.rightChild, smallest.data);
				smallest.rightChild = root.rightChild;
				smallest = getParent(getList(), smallest.rightChild.data);
			}
		}
		return this;
	}	
	
	private TreeNode<E> replaceSubTree(TreeNode<E> root, TreeNode<E> rootChild, E d) {

		TreeNode<E> parent = getParent(getList(), d);

		if (parent == null) {
			root = rootChild;
		} else if (root == parent.leftChild) {
			parent.leftChild = rootChild;
		} else {
			parent.rightChild = rootChild;
		}		
		return root;
	}
	
	private TreeNode<E> findSmallest(TreeNode<E> node){
		while(node.leftChild!=null){
			node = node.leftChild;
		}
		return node;
 	}
	
	private TreeNode<E> getParent(TreeNode<E> root, E d) {
		
		if (root.leftChild != null) {
			if (root.leftChild.data.compareTo(d) == 0) return root;
			getParent(root.leftChild, d);
		} 
		else if (root.rightChild != null)  {
			if (root.rightChild.data.compareTo(d) == 0) return root;
			return getParent(root.rightChild, d);
		}
		return root;
	}
	
	private TreeNode<E> getNode(TreeNode<E> root, E d) {
		if (root.data.compareTo(d) == 0) {
			return root;
		} 
		else if (root.data.compareTo(d) > 0) {
			return getNode(root.leftChild, d);
		} 
		else {
			return getNode(root.rightChild, d);
		}
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

	public BinaryTree<E> clone() {
		return null;
	}
	
	public  void inOrderTreeWalk(TreeNode<E> x) {
		if (x != null) {
			inOrderTreeWalk(x.leftChild);
			System.out.print(x.data);
			inOrderTreeWalk(x.rightChild);
		}
		
	}

}
