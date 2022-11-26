https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package linear;

public class Node<T> { // Node class has a generic type parameter T
	T data;
	Node<T> next;

	public Node(T data, Node<T> next) { // constructor name does NOT have a <T> next to it
		this.data = data;
		this.next = next;
	}

	public String toString() {
		return data.toString();
	}
}
