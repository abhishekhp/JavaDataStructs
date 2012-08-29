package com.datastructure;



public class DoublyLinkedList<E> {
    private Node<E> head = new Node<E>(null);
    private Node<E> tail = new Node<E>(null);
    private int length = 0;

	{
		head.setPrev(null);
		head.setNext(tail);
		tail.setPrev(head);
		tail.setNext(null);
	}

    private  class Node<E> {
        Node(E value) {
            this.value = value;
        }

        Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            setPrev(prev);
            setNext(next);
        }

        void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        void setNext(Node<E> next) {
            this.next = next;
        }

        Node<E> getPrev() {
            return prev;
        }

        Node<E> getNext() {
            return next;
        }

        E getValue() {
            return value;
        }

        private E value;
        private Node<E> prev;
        private Node<E> next;
    }

	public Node<E> get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > length) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<E> cursor = head;
			for (int i = 0; i < index; i++) {
				cursor = cursor.getNext();
			}
			return cursor;
		}
	}

	public E remove(int index) throws IndexOutOfBoundsException {
		if (index == 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<E> result = get(index);
			result.getNext().setPrev(result.getPrev());
			result.getPrev().setNext(result.getNext());
			length--;
			return result.getValue();
		}
	}
	
	public void add(int index, E value) throws IndexOutOfBoundsException {
		Node<E> cursor = get(index);
		Node<E> temp = new Node<E>(value);
		temp.setPrev(cursor);
		temp.setNext(cursor.getNext());
		cursor.getNext().setPrev(temp);
		cursor.setNext(temp);
		length++;
	}

	public void addHead(E value) {
		Node<E> cursor = head;
		Node<E> temp = new Node<E>(value);
		temp.setPrev(cursor);
		temp.setNext(cursor.getNext());
		cursor.getNext().setPrev(temp);
		cursor.setNext(temp);
		length++;
	}

	public void addTail(E value) {
		Node<E> cursor = tail.getPrev();
		Node<E> temp = new Node<E>(value);
		temp.setPrev(cursor);
		temp.setNext(cursor.getNext());
		cursor.getNext().setPrev(temp);
		cursor.setNext(temp);
		length++;
	}

	public int size() {
		return length;
	}
		
	public boolean isEmpty() {
		return length == 0;
	}
		
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("(head) - ");
		Node<E> temp = head;
		while (temp.getNext() != tail) {
			temp = temp.getNext();
			result.append(temp.getValue() + " - ");
		}
		result.append("(tail)");
		return result.toString();
	}

	public static void main(String argv[]) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.addHead(new Integer(1));
		list.addHead(new Integer(2));
		list.addTail(new Integer(9));
		list.addHead(new Integer(3));
		list.addTail(new Integer(11));
		list.add(2, new Integer(0));
		System.out.println(list);
		list.remove(list.size());
		System.out.println(list);
	}


}
