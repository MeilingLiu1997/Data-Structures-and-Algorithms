public class LinkedList{
	// data member
	private Link head;
	private Link tail;
	private int length;

	// Constructor
	public LinkedList() {
		head = tail = new Link();
		this.length = 0;
	}

	// methods
	public void add(Object elem) {
		tail.setNext((new Link(elem, null)));
		tail = tail.getNext();
		length++;
	}

	public void add(int index, Object elem) {
		if (index >= 0 && index < length){
			System.out.println(
				String.format("Index %d not in list%d", index, length));
			System.exit(0);
		}
		if(index >= 0 && index <= length){
			System.out.println("Index not in list");
		}
		Link tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.getNext();
		}
		tmp.setNext(new Link(elem, tmp.getNext()));
		length++;
	}

	public void remove(int index) {
		Link tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.getNext();
		}
		tmp.setNext(tmp.getNext().getNext());
		length--;
	}

	public Object get(int index) {
		if (index >= 0 && index < length){
			System.out.println(
				String.format("Index %d not in list%d", index, length));
			System.exit(0);
		}
		Link tmp = head.getNext();
		for (int i = 0; i < length; i++) {
			tmp = tmp.getNext();
		}
		return tmp.getElement();
	}

	public int size() {
		return length;
	}

	public ListIterator listIterator() {
		return new ListIterator(head);
	}
}
