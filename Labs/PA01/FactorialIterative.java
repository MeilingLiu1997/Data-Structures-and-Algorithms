package PA01;
/**
 * regular way to count/calculate factorial
 * 
 * @author Meiling Liu
 *
 */
public class FactorialIterative implements Factorial {
	/**
	 * create initial num
	 * for loop
	 * multiple 1*2*3*...*n
	 * 
	 * @param n
	 * @return
	 */
	@Override
	public int factorial(int n) {
		// TODO Auto-generated method stub
		return factorialIterative(n);
	}
	
	public int factorialIterative (int number){
		int num = 1;
		
		for(int i = 1; i <= number; i++) {
			num *= i;
		}
		return num;
	}

}
