package PA02;
/**
 * 
 * @author liumeiling
 *
 */

public class LinearSearch implements Practice2Search{
	
	public int search(int [] arr, int target) {
	/**
	 * this function is an implementation of the search algorithm
	 */
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public String searchName() {
		/**
		 * this function is a descriptive name of algorithm 
		 */
		return "Linear Search";
	}
}
