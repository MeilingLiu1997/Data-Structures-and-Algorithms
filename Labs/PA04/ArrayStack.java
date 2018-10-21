package cs245.PA04;

/**
 * 
 * @author liumeiling
 *
 */

public class ArrayStack implements Stack{
	private int top;
	private Object[] arr;
	
	public ArrayStack() {
		arr = new Object[10];
		top = 0;
	}
	
	@Override
	// add
	public void push(Object item) {
		// TODO Auto-generated method stub
		// check not greater than arr.length
		if (top == arr.length) {
			grow_stack();
		}
		arr[top++] = item;
	}
	
	protected void grow_stack() {
		Object[] newArr = new Object[arr.length * 2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}

	@Override
	// remove
	public Object pop() {
		// TODO Auto-generated method stub
		if(!empty()) {
			return arr[--top];
		}
		return null;
	}

	@Override
	// get
	public Object peek() {
		// TODO Auto-generated method stub
		if(!empty()) {
			return arr[top-1];
		}
		return null;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if(top == 0) {
			return true;
		}
		return false;
	}

}
