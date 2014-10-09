package assignment3;

import java.util.Iterator;

public class BinaryTree <E extends Data> implements BinaryTreeInterface<E> {
	
	protected TreeNode<E> list;
	int counter;
	
	@Override
	public BinaryTree<E> init() {
		list = null;
		return this;
	}

	@Override
	public BinaryTree<E> insert(E d) {
		
		if (list == null) {
			list = new TreeNode<E>(d);
			
		} else if (list.data.compareTo(d) < 0) {
			if (list.leftChild == null) {
				list = list.leftChild = new TreeNode<E>(d, null, null, list);
			} else {
				list = list.leftChild;
				insert(d);
			}
		} else if (list.data.compareTo(d) == 0) {
			remove ();
		} else {
			if (list.rightChild == null) {
				list = list.rightChild = new TreeNode<E>(d, null, null, list);
			} else {
				list = list.rightChild;
				insert(d);
			}
		}
		return this;
	}

	@Override
	public BinaryTree<E> remove() {
		return null;
	}

	@Override
	public boolean setFirst() {
		if (list == null) {
			return false;
		}
		while (list.parent != null) {
			list = list.parent;
		}
		return true;
	}

	@Override
	public boolean contains(E d) {
		if (list == null || list.data == d) {
			return true;
		}
		if (list.data.compareTo(d) < 0) {
			list = list.leftChild;
			contains(d);
		} else {
			list = list.rightChild;
			contains(d);
		}
		return false;
	}

	@Override
	public int size() {
		if  (list == null) {
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
