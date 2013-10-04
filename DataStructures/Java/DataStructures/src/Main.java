import datastructures.stack.IStack;
import datastructures.stack.SimpleStack;

public class Main {

	public static void main(String[] args) {

		System.out.println("## Fancy data structure test ##");

		IStack<String> stack = new SimpleStack<String>();
		stack.pop();
		stack.pop();
		stack.push("asdfafds");
		stack.push("asdfa");
		stack.pop();
	}
}
