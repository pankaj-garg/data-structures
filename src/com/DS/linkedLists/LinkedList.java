package com.DS.linkedLists;

public class LinkedList {
	Node head;

	static class Node {
		int data;

		Node next;

		Node(int inputData) {
			this.data = inputData;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		System.out.println("Started");

		LinkedList ll = new LinkedList();

		Node FirstNode = new Node(1);
		Node SecondNode = new Node(2);
		Node ThirdNode = new Node(3);

		ll.head = FirstNode;
		ll.head.next = SecondNode;
		ll.head.next.next = ThirdNode;

		ll.printList();

		Node Forth = new Node(4);
		ll = insertToListOnFront(ll, Forth);
		System.out.println("Insert 4 on head..");
		ll.printList();

		Node Fifth = new Node(5);
		ll = insertAfterGivenNode(ll, Forth, Fifth);
		System.out.println("Insert 5 after 4..");
		ll.printList();

		Node Sixtth = new Node(6);
		ll = insertAtTheEnd(ll, Sixtth);
		System.out.println("Insert 6 at the end");
		ll.printList();

		ll.deleteKeyFromList(6);
		ll.printList();
		
		ll.deleteFromPosition(0);
		ll.deleteFromPosition(1);
		ll.deleteFromPosition(2);	
		ll.printList();
		
		
		ll.deleteFromPosition(1);
		ll.printList();
		
		ll.deleteFromPosition(1);
		ll.printList();

		ll.deleteFromPosition(1);
		ll.printList();
	}
	
	void deleteFromPosition(int position)
	{
		if (position == 0) {
			this.head = this.head.next;
			return;
		}

		Node Previous = null;
		Node Current = this.head;
		
		// Start loop from head position TO the search position...
		// If the position is 1, this loop will run only one time as if i becomes 1, condition wont be satisfied.. 
		for(int i=0; (i<=position -1 && Current != null); i++) {
			System.out.println("Iteration no " + i + "- pos: " + position);
			Previous = Current;
			Current = Current.next;
		}
		
		if (Current == null) { // The position not found in the list..
			System.out.println("IN");
			return;
		}
		
		// Assign Previous node's next to Current node's next
		System.out.println("IN " + Current.data);
		Previous.next = Current.next;
	}

	void deleteKeyFromList(int key) {
		Node Previous = null;
		Node Current = this.head;

		// If the head node itself holds the key to be deleted..
		if (this.head.data == key) {
			this.head = this.head.next;
			return;
		}

		while (Current != null) {
			if (Current.data == key) {
				Previous.next = Current.next;
				break;
			}

			Previous = Current;
			Current = Current.next;
		}
	}

	static LinkedList insertToListOnFront(LinkedList ll, Node node) {
		node.next = ll.head;
		ll.head = node;

		return ll;
	}

	static LinkedList insertAfterGivenNode(LinkedList ll, Node PreviousNode, Node NewNode) {
		NewNode.next = PreviousNode.next;

		PreviousNode.next = NewNode;

		return ll;
	}

	static LinkedList insertAtTheEnd(LinkedList ll, Node NewNode) {
		Node LastNode = ll.head;
		while (LastNode.next != null) {
			LastNode = LastNode.next;
		}

		LastNode.next = NewNode;

		return ll;
	}

	void printList() {
		Node next = this.head;

		while (next != null) {
			System.out.println(next.data);

			next = next.next;
		}

		System.out.println("END \n");
	}
}
