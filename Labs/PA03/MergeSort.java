package cs245.PA03;

public class MergeSort implements SortingAlgorithm{
	public void sort(int[] a) {
		dividArray(a);
	}
	
	int[] dividArray(int[] a) {
		if (a.length <= 1) {
            return a;
        }
		
		int tmp1[] = new int[a.length/2]; 
		int tmp2[] = new int[a.length - tmp1.length];
		System.arraycopy(a, 0, tmp1, 0, tmp1.length);
        System.arraycopy(a, tmp1.length, tmp2, 0, tmp2.length);
        
        dividArray(tmp1);
        dividArray(tmp2);
        
        ms(a, tmp1, tmp2);
		return a;
	}
	
	void ms(int[] a, int[] top, int[] bot) {
		int topIndex = 0;
		int botIndex = 0;
		int a_index = 0;
		
		while(topIndex < top.length && botIndex < bot.length) {
			if(top[topIndex] <= bot[botIndex]) {
				a[a_index++] = top[topIndex++];
			} else {
				a[a_index++] = bot[botIndex++];
			}
		}
		
		while(topIndex < top.length) {
			a[a_index++] = top[topIndex++];
		}
		
		while(botIndex < bot.length) {
			a[a_index++] = bot[botIndex++];
		}
	}
	
}
