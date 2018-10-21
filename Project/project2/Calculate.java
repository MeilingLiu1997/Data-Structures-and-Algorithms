/**
	linear regression and standard deviation
 **/

public class Calculate {
	
	public static double[] linerRegression(double[] listofx, double[] listofy){
		double x = 0;
		double y = 0;
		double xy = 0;
		double x2 = 0;

		for(int i = 0; i < listofx.length; i++){
			x += i;
			x2 += Math.pow(x,2);
		}

		for(int z = 0; z < listofx.length; z++){
			xy += listofx[z] * listofy[z];
		}

		// fomular from http://www.statisticshowto.com/how-to-find-a-linear-regression-equation/
		// a = (y*x2 - x*xy)/(nx2 - Math.pow(x,2))
		// b = (nxy - x*y)/(nx2 - Math.pow(x,2))
		
		double a = (y*x2 - x*xy)/(listofx.length * x2 - Math.pow(x,2));
		double b = (listofx.length * xy - x*y)/(listofx.length * x2 - Math.pow(x,2));

		return new double[]{a, b};
	}

	// https://stackoverflow.com/questions/18390548/how-to-calculate-standard-deviation-using-java
	public static double standardDeviation(double[] listofy){
		double sum1 = 0;
		double sum2 = 0;
		double stdev = 0;

		for (int i = 0; i < listofy.length; i++){
			sum1 += listofy[i];
			sum2 += Math.pow(listofy[i], 2);
			stdev = Math.sqrt(i*sum2 - Math.pow(sum1, 2))/i;
		}
		return stdev;
	}
}