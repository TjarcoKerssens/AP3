package assignment3;

import java.util.ArrayList;
import java.util.Iterator;

public class BinaryTree<E extends Data> implements BinaryTreeInterface<E> {

	protected TreeNode<E> root;

	@Override
	public BinaryTree<E> init() {
		root = null;
		return this;
	}

	@Override
	public BinaryTree<E> insert(E d) {
		root = insert(root, d);
		return this;
	}

	private TreeNode<E> insert(TreeNode<E> root, E d) {
		if (root == null) {
			root = new TreeNode<E>(d);
		} else if (root.data.compareTo(d) > 0) {
			root.leftChild = insert(root.leftChild, d);
		} else {
			root.rightChild = insert(root.rightChild, d);
		}
		return root;
	}

	@Override
	public BinaryTree<E> remove(E d) {
		root = remove(root, d);
		return this;
	}

	private TreeNode<E> remove(TreeNode<E> root, E d) {

		if (d.compareTo(root.data) < 0) {
			root.leftChild = remove(root.leftChild, d);
		} else if (d.compareTo(root.data) > 0) {
			root.rightChild = remove(root.rightChild, d);
		} else if (root.leftChild != null && root.rightChild != null) {
			root.data = findSmallest(root.rightChild).data;
			root.rightChild = remove(root.rightChild, root.data);
		} else {
			root = (root.leftChild != null) ? root.leftChild : root.rightChild;
		}
		return root;
	}

	private TreeNode<E> findSmallest(TreeNode<E> node) {
		while (node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}

	@Override
	public boolean contains(E d) {
		return contains(root, d);
	}

	private boolean contains(TreeNode<E> root, E d) {

		if (root == null) {
			return false;
		} else if (root.data.compareTo(d) == 0) {
			return true;
		} else if (root.data.compareTo(d) > 0) {
			return contains(root.leftChild, d);
		} else {
			return contains(root.rightChild, d);
		}
	}

	@Override
	public int size() {
		int counter = 1;
		return size(root, counter);
	}

	private int size(TreeNode<E> root, int counter) {
		if (root == null) {
			return 0;
		}
		return counter + size(root.leftChild, counter)
				+ size(root.rightChild, counter);
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Iterator<E> ascendingIterator() {
		return inOrderTreeWalk(root, new ArrayList<E>()).iterator();
	}

	@Override
	public Iterator<E> descendingIterator() {
		return reverseOrderTreeWalk(root, new ArrayList<E>()).iterator();
	}

	private ArrayList<E> inOrderTreeWalk(TreeNode<E> node, ArrayList<E> list) {
		if (node != null) {
			list = inOrderTreeWalk(node.leftChild, list);
			list.add(node.data);
			list = inOrderTreeWalk(node.rightChild, list);
		}
		return list;
	}

	private ArrayList<E> reverseOrderTreeWalk(TreeNode<E> node,
			ArrayList<E> list) {
		if (node != null) {
			list = reverseOrderTreeWalk(node.rightChild, list);
			list.add(node.data);
			list = reverseOrderTreeWalk(node.leftChild, list);
		}
		return list;
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
		clone.root = clone(root);
		return clone;
	}

}
