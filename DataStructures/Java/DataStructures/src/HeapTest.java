import datastructures.tree.Heap;

public class HeapTest {

	public static void main(String[] args) {
		Heap<Integer> p = new Heap<Integer>();

		for (int i = 0; i < 10; i++) {
			p.insert((int) (Math.random() * 100));
		}

		System.out.println(p.toString() + "\r\n");

		while (!p.isEmpty()) {
			System.out.print("Max: " + p.delete() + " : ");
			System.out.println(p.toString() + "\r\n");
		}
	}
}
