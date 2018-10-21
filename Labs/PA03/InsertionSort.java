package cs245.PA03;

public class InsertionSort implements SortingAlgorithm{
	public void sort(int[] a) {
		// TODO Auto-generated method stub
		for(int i = 1; i < a.length; i++) {		//i keeps tracking, the first item was sorted
			int temp = a[i];
			int j = i-1;
			while(j >= 0 && temp < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
