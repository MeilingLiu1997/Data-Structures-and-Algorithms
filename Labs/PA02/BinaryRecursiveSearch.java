package PA02;
/**
 * 
 * @author liumeiling
 *
 */

public class BinaryRecursiveSearch implements Practice2Search{

	public int search(int[] arr, int target) {
		return search(arr, target, 0, arr.length-1);
	};
	
	public int search(int[] arr, int target, int min, int max) {
		// base case
		if(max < min) {
			return -1;
		}
		
		int mid = (min + max) / 2;
		if(arr[mid] == target) {
			return mid;
		}
		if((arr[mid] - target) < 0) {
			return search(arr, target, min, mid-1);
		} else {
			return search(arr, target, mid+1, max);
		}
	}
	
	public String searchName() {
	/**
	 * this function is a descriptive name of algorithm 
	 */
		return "Binary Recursive Search";
	}
}
