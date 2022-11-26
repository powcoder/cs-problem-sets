https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

class BSTNode<T extends Comparable<T>> {
	T key;
	BSTNode<T> left;
	BSTNode<T> right;

	public BSTNode(T key) {
		this.key = key;
		left = null;
		right = null;
	}
}

// T is any type that implement the method compareTo()
public class BST<T extends Comparable<T>> {
	BSTNode<T> root;

	public BST() {
		root = null;
	}

	// search method returns matching object
	public T search(T key) {
		BSTNode<T> current = root;
		while (current != null) {
			int c = key.compareTo(current.key);
			if (c == 0) {
				return current.key;
			}
			current = c < 0 ? current.left : current.right;
		}
		return null;
	}

	public void insert(T item) throws IllegalArgumentException {
		BSTNode<T> current = root;
		BSTNode<T> parent = null;
		int c = 0;
		while (current != null) { // search until fail
			c = item.compareTo(current.key);
			if (c == 0)  // BST does not allow duplicated nodes
				throw new IllegalArgumentException("Duplicate key: " + item);
			parent = current;
			current = c < 0 ? current.left : current.right;
		}
		// create new node for item
		BSTNode<T> newNode = new BSTNode<T>(item);
		if (parent == null) { // tree was empty
			root = newNode;
			return;
		}
		if (c < 0) 
			parent.left = newNode;
		else
			parent.right = newNode;
	}

	// deletes object for key, and returns deleted object
	public T delete(T key) throws NoSuchElementException {
		// search and locate the node to be deleted
		BSTNode<T> current = root;
		BSTNode<T> parent = null;
		
		if(root == null)
			throw new NoSuchElementException("empty tree");
		
		while (current != null) {
			int c = key.compareTo(current.key);
			if (c == 0) {
				break;
			}
			parent = current;
			current = c < 0 ? current.left : current.right;
		}
		
		if (current == null) {
			throw new NoSuchElementException(key + " not found");
		}

		T temp = current.key; // to be returned at end of method

		// case 3: to-be-deleted node has two children
		if (current.left != null && current.right != null) {
			// find inorder predecessor
			BSTNode<T> pred = current.left;
			parent = current;
			while (pred.right != null) {//Why not check whether pred is not null? 
										//Since we reach pred.right != null either from line 90 or line 97.
										//if from line 90, it means pred is current.left (line 89) 
										//which cannot be null because of the condition at line 87.
										//if from line 97, it means pred is the previous pred.right
										//which cannot be null because of the condition at line 91.
				parent = pred;
				pred = pred.right;
			}
			current.key = pred.key; // copy pred's key into current
			current = pred; // transform into deleting a node with at most one child 
							// since at least pred.right is null because of the loop's exit condition
		}

		// 1. current is the node to delete and parent is its parent
		// 2. current has at most one child
		if (parent == null) {// deleting the root node, meaning in the original tree, 
			  				 // root has at most one child, otherwise parent has been set as non-null in line 90 or 92
			root = current.left != null ? current.left : current.right; // case 1 and 2
			return temp;
		}

		// case 1 (two subcases) and case 2 (4 subcases)
		if (current == parent.right) {
			parent.right = current.left != null ? current.left : current.right;
		} else {
			parent.left = current.left != null ? current.left : current.right;
		}
		return temp;
	}

	public static void main(String[] args) {		
		BST<Student> studentBST = new BST<Student>();
		studentBST.insert(new Student("B053","David Jones","110 Frelinghuysen Rd"));
		studentBST.insert(new Student("D032","Lucy Smith", "305 Univeristy St"));
		studentBST.insert(new Student("M016","Emily Taylor","77 Massachusetts Ave"));
		
		// get address for a student based on the id
		Student student = studentBST.search(new Student("D032",null,null));
		System.out.println(student.name + ": " + student.address);
		
				
	}
}

//Student MUST implement the Comparable interface
class Student implements Comparable<Student> {
	String id; // the key
	String name;
	String address;

	public Student(String id, String name, String addr) {
		this.id = id;		
		this.name = name;
		this.address = addr;
	}

	public int compareTo(Student other) {
		return id.compareTo(other.id); //"DS001" < "DS002"
	}

}
