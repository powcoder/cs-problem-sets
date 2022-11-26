https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package linear;

import java.util.NoSuchElementException;

public class Stack<T> {
	private Node<T> front;
	private int size;

	public Stack() {
		front = null;
		size = 0;
	}

	public void push(T item) {
		front = new Node<T>(item, front);
		size++;
	}

	public T pop() throws NoSuchElementException {
		if (front == null)
			throw new NoSuchElementException();
		T temp = front.data;
		front = front.next;
		size--;
		return temp;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		return size;
	}

	public void clear() {
		front = null;
		size = 0;
	}
}