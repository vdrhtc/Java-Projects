package core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LinkedDynamicArray implements IDynamicArray {

	public LinkedDynamicArray()
	{
		size = 0;
		logger.setLevel(Level.OFF);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public boolean contains(Object obj) {
		Node scanner = first;
		while (scanner.next != null) {
			if (scanner.item.equals(obj)) {
				return true;
			}
			scanner = scanner.next;
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		logger.info("Converting to array");
		Object[] arr = new Object[size];
		Node scanner = first;
		int i = 0;
		while (scanner != null) {
			logger.info("Step: " + i + " Object: " + scanner.item.toString());
			arr[i] = scanner.item;
			i++;
			scanner = scanner.next;
		}
		logger.info("Exiting");
		return arr;
	}

	@Override
	public boolean add(Object obj) {

		if (size == 0) {
			logger.info("Initial add");
			first = new Node(null, obj, null);
			size++;
			return true;
		} else {
			logger.info("Adding " + size + "th element");
			Node scanner = first;
			while (scanner.next != null) {
				scanner = scanner.next;
			}
			scanner.next = new Node(scanner, obj, null);
			size++;
			return true;
		}
	}

	@Override
	public boolean remove(Object obj) {

		logger.info("Removing [" + obj.toString() + "]");
		Node scanner = first;

		while (scanner != null) {
			logger.info("--Cycling: " + scanner.item.toString());

			if (scanner.item.equals(obj)) {
				logger.info("Found: " + scanner.item.toString());

				if (scanner.prev == null)
					first = scanner.next;
				else
					scanner.prev.next = scanner.next;
				size--;
				logger.info("" + size);
				return true;
			}
			scanner = scanner.next;
		}
		return false;
	}

	@Override
	public Object remove(int index) {

		logger.info("Removing by index");
		Node scanner = first;
		int i = 0;
		Object tmp;

		while (scanner != null) {
			logger.info("--Cycling: " + scanner.item.toString());

			if (i == index) {
				logger.info("Found index");
				tmp = scanner.item;

				if (scanner.prev == null)
					first = scanner.next;
				else
					scanner.prev.next = scanner.next;
				size--;
				logger.info("" + size);
				return tmp;
			}
			i++;
			scanner = scanner.next;
		}
		return null;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public Object get(int index) {
		Node scanner = first;
		int i = 0;

		while (scanner != null) {
			logger.info("--Cycling: " + scanner.item.toString());

			if (i == index) {
				return scanner.item;
			}
			i++;
			scanner = scanner.next;
		}
		return null;
	}

	@Override
	public Object set(int index, Object obj) {
		Node scanner = first;
		int i = 0;

		while (scanner != null) {
			logger.info("--Cycling: " + scanner.item.toString());

			if (i == index) {
				scanner.item = obj;
			}
			i++;
			scanner = scanner.next;
		}
		return null;
	}

	@Override
	public int indexOf(Object obj) {
	
		Node scanner = first;
		int i=0;
		
		while (scanner != null) {
			logger.info("--Cycling: " + scanner.item.toString());

			if (scanner.item.equals(obj)) {
				logger.info("Found: " + scanner.item.toString());
				return i;
			}
			i++;
			scanner = scanner.next;
		}
		return -1;
	}

	private int size = 0;
	Node first;
	Logger logger = Logger.getLogger("LinkedDynamicArray");

	private static class Node {
		public Node(Node prev, Object element, Node next)
		{
			this.item = element;
			this.prev = prev;
			this.next = next;
		}

		Object item;
		Node prev;
		Node next = null;
	}

}
