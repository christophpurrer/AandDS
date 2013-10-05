package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BuildTree<T> {

	/**
	 * simple node class
	 * 
	 * @author Christoph
	 * 
	 * @param <T>
	 */
	public static class Node<T> {

		// properties
		public T value;
		public List<Node<T>> children = new ArrayList<Node<T>>();

		public Node(T value) {
			super();
			this.value = value;
		}
	}

	public Node<T> rebuildTree(T[] array) {
		Node<T> rootNode = null;
		if (array != null && array.length > 0) {

			// 1.) create and HashMap nodes
			Map<T, Node<T>> nodes = new HashMap<T, Node<T>>();
			for (int i = 0; i < array.length; i++) {
				nodes.put(array[i], new Node<T>(array[i]));
			}

			// 2.) link nodes
			for (Node<T> node : nodes.values()) {
				T parendId = getParentId(node.value);
				if (isRootId(parendId)) {
					rootNode = node;
				}

				Node<T> parentNode = nodes.get(parendId);
				if (parentNode != null) {
					parentNode.children.add(node);
				}
			}
		}

		return rootNode;
	}

	protected abstract boolean isRootId(T parendId);

	protected abstract T getParentId(T value);
}
