package assignment3;

import java.util.Iterator;

public class BinaryTree <E extends Data> implements BinaryTreeInterface<E> {
	
	protected TreeNode<E> list;
	int counter;
	
	@Override
	public BinaryTree<E> init() {
		list=null;
		return this;
	}

	@Override
	public BinaryTree<E> insert(E d) {
		setFirst();
		if (list == null) {
			list = new TreeNode<E>(d);
			
		} else if (list.data.compareTo(d) > 0) {
			if (list.leftChild == null) {
				list.leftChild = new TreeNode<E>(d, null, null, list);
				list.leftChild.parent = list;
				list = list.leftChild;
			} else {
				list = list.leftChild;
				insert(d);
			}
		} else if (list.data.compareTo(d) == 0) {
			remove ();
		} else {
			if (list.rightChild == null) {
				list.rightChild = new TreeNode<E>(d, null, null, list);
				list.rightChild.parent = list;
				list = list.rightChild;
			} else {
				list = list.rightChild;
				insert(d);
			}
		}
		return this;
	}

	@Override
	public BinaryTree<E> remove() {
		if(list.leftChild == null){
			if(list.parent!=null && list.parent.leftChild.equals(list)){
				list.rightChild.parent = list.parent;
				list.parent.leftChild = list = list.rightChild;
			}else if(list.parent!=null){
				list.rightChild.parent = list.parent;
				list.parent.rightChild = list = list.rightChild;
			}else{
				list.rightChild.parent = null;
				list = list.rightChild;
			}
		}else if(list.rightChild == null){
			if(list.parent!=null && list.parent.leftChild.equals(list)){
				list.leftChild.parent = list.parent;
				list.parent.leftChild = list = list.leftChild;
			}else if(list.parent!=null){
				list.leftChild.parent = list.parent;
				list.parent.rightChild = list = list.leftChild;
			}else{
				list.leftChild.parent = null;
				list = list.leftChild;
			}
		}else{
			TreeNode<E> temp = findSmallest(list.rightChild);
			list.data = temp.data;
			list=temp;
			remove();
		}
		return this;
	}
	
	public TreeNode<E> getList() {
		return list;
	}
	
	public E retrieve(){
		return list.data;
	}
	
	private TreeNode<E> findSmallest(TreeNode<E> node){
		while(node.leftChild!=null){
			node = node.leftChild;
		}
		return node;
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
		if(list==null){
			return false;
		}
		setFirst();		
		if(list.data.compareTo(d)<0){
			if(list.rightChild!=null){
				list = list.rightChild;
				return contains(d);
			}else{
				return false;
			}
		}
		
		if(list.data.compareTo(d)>0){
			if(list.leftChild!=null){
				list = list.leftChild;
				return contains(d);
			}else{
				return false;
			}
		}
		
		return true;
		
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
