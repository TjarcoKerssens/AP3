package assignment3;

import java.util.Iterator;

public class BinaryTree<E extends Data> implements BinaryTreeInterface<E> {

	protected TreeNode<E> list;
	int counter;

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
	public BinaryTree<E> remove() {

		return this;
	}

	public TreeNode<E> getList() {
		return list;
	}

	public E retrieve() {
		return list.data;
	}

	private TreeNode<E> findSmallest(TreeNode<E> node) {
		while (node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}


	@Override
	public boolean contains(E d) {
		if (list == null) {
			return false;
		}
		if (list.data.compareTo(d) < 0) {
			if (list.rightChild != null) {
				list = list.rightChild;
				return contains(d);
			} else {
				return false;
			}
		}

		if (list.data.compareTo(d) > 0) {
			if (list.leftChild != null) {
				list = list.leftChild;
				return contains(d);
			} else {
				return false;
			}
		}

		return true;

	}

	@Override
	public int size() {
		if (list == null) {
			return 0;
		}
		if (!(list.leftChild == null)) {
			counter++;
			list = list.leftChild;
			size();
		}
		if (!(list.rightChild == null)) {
			counter++;
			list = list.rightChild;
			size();
		}
		return counter;
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

}
