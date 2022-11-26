https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package linear;

import java.util.ArrayList; //import the class in order to use it
import java.util.NoSuchElementException;

public class StackUsingArrayList<T> {
	
	private ArrayList<T> list = new ArrayList<T>();

	public void push(T v) {
		list.add(v);
	}

	public T peek() {
		return list.get(list.size()-1);
	}

	public T pop() throws NoSuchElementException{
		if(list.size() == 0)
			throw new NoSuchElementException();
		return list.remove(list.size()-1);
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}

	public static void main(String[] args) {
		StackUsingArrayList<String> stack = new StackUsingArrayList<String>();
		stack.push("!");
		stack.push("CS112");
		stack.push(" ");
		stack.push("to");
		stack.push(" ");
		stack.push("Welcome");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()); //Welcome to CS112
		}
	}
}
