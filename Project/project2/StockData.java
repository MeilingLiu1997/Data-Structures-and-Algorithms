import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException; 

public class StockData {
	// data member
	private Date date;
	private float open;
	private float high;
	private float low;
	private float close;
	private float adj_close;
	private int volume;
	
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	// constructor

	// unreported exception ParseException; must be caught or declared to be thrown
	// source from https://stackoverflow.com/questions/16116652/parseexception-java
	public StockData(String date, float open, float high, float low, float close, float adj_close, int volume) throws ParseException {
		
		// convert String to Date
		// from https://stackoverflow.com/questions/6510724/how-to-convert-java-string-to-date-object
		this.date = simpleDateFormat.parse(date);
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adj_close = adj_close;
		this.volume = volume;
	}
	
	
	// mutators / accessors
	public Date getDate() {
		return this.date;
	}
	public float getOpen() {
		return this.open;
	}
	public float getHigh() {
		return this.high;
	}
	public float getLow() {
		return this.low;
	}
	public float getClose() {
		return this.close;
	}
	public float getAdjClose() {
		return this.adj_close;
	}
	public int getVolume() {
		return this.volume;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public void setAdjClose(float adj_close) {
		this.adj_close = adj_close;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
