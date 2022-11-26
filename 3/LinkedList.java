https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package linear;

import java.util.NoSuchElementException;

public class LinkedList<T> {
	Node<T> front;
	int size;

	public LinkedList() { // empty linked list to start with
		front = null;
		size = 0;
	}

	public void addFront(T item) {
		front = new Node<T>(item, front);
		size++;
	}

	public void deleteFront() throws NoSuchElementException {
		if (front == null) {
			// throw new NoSuchElementException();
			throw new NoSuchElementException("Can't delete from an empty list");
		}
		front = front.next;
		size--;
	}

	public T getFront() throws NoSuchElementException {
		if (front == null) {
			// throw new NoSuchElementException();
			throw new NoSuchElementException("Can't get at front of an empty list");
		}
		return front.data;
	}

	public boolean search(T target) {
		for (Node<T> ptr = front; ptr != null; ptr = ptr.next) {
			if (target.equals(ptr.data)) {
				return true;
			}
		}
		return false;
	}

	// while loop version, stylized single-line output
	public void traverse() {
		if (front == null) {
			System.out.println("Empty list");
			return;
		}
		System.out.print(front.data); // first item
		Node<T> ptr = front.next; // prepare to loop starting with second item
		while (ptr != null) {
			System.out.print(" --> " + ptr.data);
			ptr = ptr.next;
		}
		System.out.println();
	}

	// use size to trace the number, then we can achieve O(1) here rather than O(n) for traversal
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0; //return front == null;
	}

	public static void main(String[] args) {

		// set up a linked list of Strings
		LinkedList<String> strLL = new LinkedList<>();
		strLL.addFront("cs112");
		strLL.addFront("cs111");
		strLL.traverse();
		strLL.deleteFront();
		strLL.traverse();
		boolean found = strLL.search("cs112");
		if (found) {
			System.out.println("found \"cs112\"\n");
		}

		// set up a linked list of integers
		LinkedList<Integer> intll = new LinkedList<>();
		int x = 5;
		intll.addFront(x); // auto boxes value of x into an Integer object
		intll.addFront(15); // auto boxes -15 into an Integer object
		intll.addFront(-10); // auto boxes -10 into an Integer object

		intll.traverse();

		x = intll.getFront(); // auto unboxes returned object into a primitive
		System.out.println("front = " + x);

		try {	//The try statement encloses computation code which might trigger exceptions
			System.out.println("\ndeleting front");
			intll.deleteFront();
			intll.traverse();
			System.out.println("\ndeleting front");
			intll.deleteFront();
			intll.traverse();
			System.out.println("\ndeleting front");
			intll.deleteFront();
			intll.traverse();
			System.out.println("\ndeleting front");

			intll.deleteFront(); // trying to delete from an empty list

			System.out.println("DONE!");
		} catch (NoSuchElementException e) {	
			//The catch statement encloses code to be executed if an exception is triggered in the try block
			System.out.println(e.getMessage());
		}
	}

}