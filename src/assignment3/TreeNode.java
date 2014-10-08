package assignment3;


class TreeNode<E extends Data> implements TreeNodeInterface<E> {

	E data;
	TreeNode<E> leftChild, rightChild, parent;

	public TreeNode (E d) {
		this(d, null, null, null);
	}


	public TreeNode (E data, TreeNode<E> leftChild, TreeNode<E> rightChild, TreeNode<E> parent) {
		this.data = data == null ? null : (E) data.clone();
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}

	
	public TreeNode<E> clone () {
		TreeNode<E> clone;
		try{
			clone = (TreeNode<E>)super.clone();
		}catch(CloneNotSupportedException CNSE){
			throw new Error("Impossible! instance cannot be cloned");
		}

		clone.data = data == null ? null : (E) data.clone();

		return clone;
	}
}
