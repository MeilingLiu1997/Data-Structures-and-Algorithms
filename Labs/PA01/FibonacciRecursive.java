package PA01;
/**
 * fibonacci in recursive way
 * 
 * @author Meiling Liu
 *
 */
public class FibonacciRecursive implements Fibonacci {
	/**
	 * base case <=1, return itself;
	 * return and add previous 2 items
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacciRecursive(int n){
		if (n <= 1) {
			return n;
		}
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);			
	}

	@Override
	public int fibonacci(int n) {
		// TODO Auto-generated method stub
		return fibonacciRecursive(n);
	}
}
