package PA01;
/**
 * factorial in recursive way
 * 
 * @author Meiling Liu
 *
 */
public class FactorialRecursive implements Factorial {
	/**
	 * base case 1;
	 * multiple with previous one (n-1) each time
	 * return to previous item
	 * 
	 * @param n
	 * @return
	 */
	
	public int factorialRecursive(int n){
		if (n == 1) {
			return 1;
		}
		return n * factorialRecursive(n-1);			
	}

	@Override
	public int factorial(int n) {
		// TODO Auto-generated method stub
		return factorialRecursive(n);
	}
}
