public class Link {
	// data member
	private Object element;
	private Link next;

	// constructor
	public Link (Object newElement, Link newNext) {
		element = newElement;
		next = newNext;
	}
	Link() { }

	public Link getNext() {	//accessor
		return next;
	}
	
	public void setNext(Link newNext) {	// nutator
		next = newNext;
	}

	public Object getElement() {
		return element;
	}
	
	public void setElement(Object newElement) {
		element = newElement;
	}
}
