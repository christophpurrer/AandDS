package datastructures.list;

public class SinglyLinkedList<T> {

	private T data;
	private SinglyLinkedList<T> next;

	public SinglyLinkedList(T value) {
		this.data = value;
		this.next = null;
	}

	public SinglyLinkedList<T> InsertNext(T value) {
		SinglyLinkedList<T> node = new SinglyLinkedList<T>(value);
		if (this.next == null) {
			this.next = node;
		} else {
			// Insert in the middle
			SinglyLinkedList<T> temp = this.next;
			node.next = temp;
			this.next = node;
		}
		return node;
	}

	public int DeleteNext() {
		if (next == null) {
			return 0;
		}

		this.next = this.next.next; // can be NULL here
		return 1;
	}

	public void Traverse(SinglyLinkedList<T> node) {
		if (node == null) {
			node = this;
		}
		System.out.println("\n\nTraversing in Forward Direction\n\n");

		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
