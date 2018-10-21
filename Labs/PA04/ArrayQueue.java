package cs245.PA04;

/**
 * 
 * @author liumeiling
 *
 */
public class ArrayQueue implements Queue{
	private Object[] arr;
	private int head;
	private int tail;
	
	public ArrayQueue() {
		arr = new Object[10];
		head = 0;
		tail = 0;
	}
	
	@Override
	// remove
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(empty()) {
			return null;
		}
		Object item = arr[head];
		head = (head + 1) % arr.length;
		
		if(head == arr.length) {
			head = 0;
		}
		return item;
	}

	@Override
	// add
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if((tail + 1)% arr.length == head) {
			grow_queue();
		}
		arr[tail] = item;
		tail = (tail + 1) % arr.length;
		
		if(tail == arr.length) {
			tail = 0;
		}	
	}
	
	protected void grow_queue() {
		Object[] newArr = new Object[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if(head == tail) {
			head = tail = 0;
			return true;
		}
		return false;
	}

}
