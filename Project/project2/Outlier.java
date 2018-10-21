/**
	Process stock linear and standard deviation
		update year/month/date
**/
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;


public class Outlier{
    public ArrayList<StockData> transform (Date start_date, ArrayList<StockData> stocks){
        ArrayList<StockData> complete_Stocks = checkOneYear(start_date, stocks);
        return checkStav(complete_Stocks);
    }
	// Source from:
	// https://stackoverflow.com/questions/25347073/how-can-i-change-month-only-in-java-date-object
	public Date checkDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); // your date (java.util.Date)
		cal.add(Calendar.YEAR, +1); // You can -/+ x Year here to go back in history or move forward.
		cal.add(Calendar.DATE, -1);
		return cal.getTime(); // New date
	}

    public ArrayList<StockData> checkOneYear(Date startDate, ArrayList<StockData> stocks){
        Date endDate = checkDate(startDate);
        ArrayList<StockData> completedStocks = new ArrayList<StockData>();
        // compare dates:
        // from https://stackoverflow.com/questions/2592501/how-to-compare-dates-in-java
        for(StockData s: stocks){
            if(s.getDate().before(startDate)){
                continue;
            }
            if(s.getDate().before(endDate)){
                completedStocks.add(s);
            } else {
                break;
            }
        }
        if(completedStocks.size() < 2){
            System.out.println("There is insufficient data for this period.");
            System.exit(1);
        }
        return completedStocks;
    }

	public ArrayList<StockData> checkStav(ArrayList<StockData> one_stock) {
		double[] xcell = new double[one_stock.size()];
        double[] ycell = new double[one_stock.size()];
        
        int index = 0;
        for (StockData s : one_stock) {
            xcell[index] = index;
            ycell[index] = s.getClose();
            index++;
        }
//from http://www.statisticshowto.com/how-to-find-a-linear-regression-equation/
        int j = 0;

        double[] result = Calculate.linerRegression(xcell, ycell);
        double standardDeviation = Calculate.standardDeviation(ycell);
        ArrayList<StockData> outliers = new ArrayList<StockData>();

        for (StockData s : one_stock) {
	        //The equation has the form Y = a+bX, 
	                // b is the slope of the line and a is the y-intercept.
        	        // X is the independent variable (i.e. it is plotted on the X axis), 
            double yEquation = result[0] + result[1] * xcell[j];

			//if differences greater than σ2 are used to determine the outliers in the stock price
            if (Math.pow(ycell[j] - yEquation, 2) > standardDeviation) {
                outliers.add(s);
            }
            j++;
        }
        return outliers;
	}
}