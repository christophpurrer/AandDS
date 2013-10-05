package sorting;

import datastructures.BuildTree.Node;
import datastructures.BuildTreeInteger;

public class BuildTreeTest {

	public static void main(String[] args) {
		new BuildTreeTest();
	}

	public BuildTreeTest() {
		BuildTreeInteger buildTreeInteger = new BuildTreeInteger();

		Node<Integer> rootNode = buildTreeInteger.rebuildTree(new Integer[] { 9, 8, 5, 3, 1, 2, 4, 6, 11, 12 });
		if (rootNode != null) {
			System.out.println(rootNode.value);
			print(rootNode);
		}
	}

	private void print(Node<Integer> node) {
		if (node != null) {
			if (node.children != null && node.children.size() > 0) {
				for (Node<Integer> child : node.children) {
					System.out.print(child.value + " ");
				}
				System.out.println();

				for (Node<Integer> child : node.children) {
					print(child);
				}
			}
		}
	}
}
