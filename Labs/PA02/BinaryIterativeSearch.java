package PA02;

/**
 * 
 * @author liumeiling
 *
 */

public class BinaryIterativeSearch implements Practice2Search{
	public int search(int[] arr, int target) {
		return search(arr, target, 0, arr.length);
	};
	
	public int search(int[] arr, int target, int min, int max) {
		int mid;
		//loop
		while (min < max) {
			mid = (min + max) / 2;
			if(arr[mid] == target) {
				return mid;
			}
			if((arr[mid] - target) < 0) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
		}
		return -1;
	}
	public String searchName() {
		/**
		 * this function is a descriptive name of algorithm 
		 */
		return "Binary Iterative Search";
	}
}
