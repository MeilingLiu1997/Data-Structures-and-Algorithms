import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class A02 {
	// unreported exception ParseException; must be caught or declared to be thrown
	// source from https://stackoverflow.com/questions/16116652/parseexception-java
	
	public static void main(String[] args) throws ParseException{
		Scanner in = new Scanner(System.in);
		System.out.print("Stock Symbol: ");
		String symbol = in.next();
		System.out.print("Starting date: ");

		String startDate = in.next();
		String[] s2 = startDate.split("-");
		String end_date = Integer.toString(Integer.parseInt(s2[0]) + 1) + s2[1] 
						+ Integer.toString(Integer.parseInt(s2[2]) - 1);
    	System.out.println("Outliers for " + symbol + " " + s2[0] + ":");

		// convert String to Date
		// from https://stackoverflow.com/questions/6510724/how-to-convert-java-string-to-date-object
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date start_date = df.parse(startDate);

		StockBuilder stockBuilder = new StockBuilder();
		String filename = symbol + ".CSV";
		LinkedList tmp_list1 = stockBuilder.builder(filename);

		ArrayList<StockData> list1 = new ArrayList<StockData>(tmp_list1);

		Outlier outliers = new Outlier();
		ArrayList<StockData> list2 = outliers.transform(start_date,list1);
		for(StockData stockData: list2){		// String.format source from https://www.dotnetperls.com/format-java

			System.out.println(
                    String.format(
                            "%s: %.2f",
                            StockData.simpleDateFormat.format(stockData.getDate()),
                            stockData.getClose()));
		}
	}
}
