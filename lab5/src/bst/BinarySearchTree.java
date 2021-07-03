package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    int size;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if(root==null) {
			root = new BinaryNode<>(x);
			size++;
			return true;
		}
		else {
			return addRecursive(root, x);
		}
	}
	
	private boolean addRecursive(BinaryNode<E> node, E x) {
		int comp = x.compareTo(node.element);
		
		if(comp == 0) {
			return false;
		}
		else if(comp > 0){
			 	if(node.right == null) {
			 		node.right = new BinaryNode<>(x);
			 		size++;
			 		return true;
			 	}
			 	else {
			 		return addRecursive(node.right, x);
			 	}
				
		}
		else {
			if(node.left == null) {
				node.left = new BinaryNode<>(x);
				size++;
				return true;
			}
			else {
				return addRecursive(node.left, x);
			}
		}
	}
	
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		if(root == null) {
			return 0;
		}
		else {
			return getHeight(root, 0);
			
		}
		
	}
	
	private int getHeight(BinaryNode<E> node, int height) {
		if(node == null) {
			return height;
		}
		else {
			int right = getHeight(node.right, height+1);
			int left = getHeight(node.left, height +1);
			return Math.max(left, right);
		}
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		if(root == null) {
			return;
		}
		else {
			PrintRec(root);
		}
	}
	
	private void PrintRec(BinaryNode<E> node) {
		if(node != null) {
			PrintRec(node.left);
			System.out.print(node);
			PrintRec(node.right);
			
		}
	}
	
	

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		toArray(root, a, 0); 
		root = buildTree(a, 0, a.length -1); 
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if(n == null){ 
			return index;
		}
		index = toArray(n.left, a, index); 
		a[index] = n.element; 
		return toArray(n.right, a, index + 1); 
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		if(first > last){
			return null;
		}
		int middle = (first + last) / 2; 
		BinaryNode<E> root = new BinaryNode<E>(a[middle]); 
		root.left = buildTree(a, first, middle -1);  
		root.right = buildTree(a, middle +1, last); 
		return root;
	}	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
	
	
	public static void main(String[] args) {
		BSTVisualizer bstv = new BSTVisualizer("Hej", 500, 500);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.add(3);
		bst.add(1);
		
		bst.add(5);
		bst.add(7);
		
		bst.add(9);

		
		bst.add(13);
		bst.add(-11);


		bst.rebuild();
		
		bstv.drawTree(bst);
		
	}
	
}
