/**
	read file from CSV
**/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.text.ParseException; 


public class StockBuilder{
	public LinkedList builder(String filename){
		LinkedList list = new LinkedList();

		//open file
		File inputFile = new File(filename);
		try (Scanner input = new Scanner(inputFile)) {  //Create a new Scanner to read input from the file
			
			input.useDelimiter(",|\n");
			while(input.hasNext()) {
				String line = input.nextLine(); // Read in the first line and ignore it.
				String date = input.next();
				String[] s1 = date.split("-");
				float open = input.nextFloat();
				float high = input.nextFloat();
				float low = input.nextFloat(); 
				float close = input.nextFloat(); 
				float adj_close = input.nextFloat();
				int volume = input.nextInt();

				StockData one_stock = new StockData(date,open,high,low,close,adj_close,volume);
				list.add(one_stock);
			}
		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		} catch (ParseException p){	// unreported exception ParseException; must be caught or declared to be thrown
			System.out.println(p.getMessage());			// source from https://stackoverflow.com/questions/16116652/parseexception-java
	

		}
		return list;
	}

}