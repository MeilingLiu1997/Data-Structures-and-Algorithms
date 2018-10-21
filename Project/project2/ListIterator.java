public class ListIterator{
    
    // data member
	private Link current;

	//constructor
	public ListIterator(Link current) {
		this.current = current;	
	}

	// method
	public Object next() {
		try {
			Object result = current.getElement();
			current = current.getNext();
			return result;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean hasNext() {
		return current != null && current.getNext() != null;
	}
}
