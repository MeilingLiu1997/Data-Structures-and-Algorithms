package PA01;
/**
 * regular way to count/calculate fibonacci
 * 
 * @author Meiling Liu
 *
 */
public class FibonacciIterative implements Fibonacci {
	/**
	 * fibonacci: sum of two items
	 * create int[] f
	 * f(0) = 0			= 0
	 * f(1) = 1			= 1
	 * f(2) = 0+1 		= 1
	 * f(3) = 1+1	 	= 2
	 * f(4) = 1+2		= 3
	 * ...
	 * add (n-1) and (n-2);
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci(int n){
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}


}
