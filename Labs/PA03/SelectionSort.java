package cs245.PA03;

public class SelectionSort implements SortingAlgorithm{
	public void sort(int[] a) {
		// TODO Auto-generated method stub
		for(int i = 0; i < a.length; i++) {
			int smallest = smallest(a, i);
			swap(a, smallest, i);
		}
	}
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int smallest(int[] a, int start) {
		int smallest = start;
		for(int i = start+1; i < a.length; i++) {
			if(a[i] < a[smallest]) {
				smallest = i;
			}
		}
		return smallest;
	}
}
