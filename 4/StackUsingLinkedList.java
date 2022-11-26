https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package linear;

public class StackUsingLinkedList<T> {

	private LinkedList<T> list = new LinkedList<T>();

	public void push(T v) {
		list.addFront(v);
	}

	public T peek() {
		return list.getFront();
	}

	public T pop() {
		return list.deleteFront();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public static void main(String[] args) {
		StackUsingLinkedList<String> stack = new StackUsingLinkedList<String>();
		//stack.pop(); // an exception is triggered
		stack.push("CS112");
		stack.push(" ");
		stack.push("to");
		stack.push(" ");
		stack.push("Welcome");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());  //Welcome to CS112
		}
	}
}
