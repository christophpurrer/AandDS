package datastructures.tree;

public class BinaryTree<T extends Comparable<T>> {

	// Root node pointer. Will be null for an empty tree.
	private Node<T> root;

	/**
	 * --Node-- The binary tree is built using this nested node class. Each node
	 * stores one data element, and has left and right sub-tree pointer which
	 * may be null. The node is a "dumb" nested class -- we just use it for
	 * storage; it does not have any methods.
	 */
	@SuppressWarnings("hiding")
	private class Node<T> {

		private Node<T> left;
		private Node<T> right;
		private T data;

		protected Node(T newData) {
			this.left = null;
			this.right = null;
			this.data = newData;
		}
	}

	/**
	 * Creates an empty binary tree -- a null root pointer.
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public boolean lookup(T data) {
		return (lookup(root, data));
	}

	/**
	 * Recursive lookup -- given a node, recur down searching for the given
	 * data.
	 */
	private boolean lookup(Node<T> node, T data) {
		if (node == null) {
			return false;
		}

		if (data == node.data) {
			return true;
		} else if (data.compareTo(node.data) < 0) {
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper.
	 */
	public void insert(T data) {
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node<T> insert(Node<T> node, T data) {
		if (node == null) {
			node = new Node<T>(data);
		} else {
			if (data.compareTo(node.data) < 0) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}
}