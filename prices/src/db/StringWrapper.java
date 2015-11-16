package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Стринг рапър.
 * @author lubo
 *
 */
public class StringWrapper implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2849906364805196393L;
	
	
	/** the string value. */
	String val;
	
	/** The add zeroif decimal pointfirst. */
	private boolean addZeroifDecimalPointfirst = false;
	
	

	/**
	 * Instantiates a new string wrapper.
	 *
	 * @param s the s
	 */
	public StringWrapper(String s) {
		// TODO Auto-generated constructor stub
		val = s;
	}
	
	/**
	 * Instantiates a new string wrapper.
	 *
	 * @param s the s
	 * @param addZeroifDecimalPointfirst the add zeroif decimal pointfirst
	 */
	public StringWrapper(String s, boolean addZeroifDecimalPointfirst) {
		// TODO Auto-generated constructor stub
		val = s;
		this.addZeroifDecimalPointfirst = addZeroifDecimalPointfirst;
	}
	
	//getters & setters
	/**
	 * Gets the val.
	 *
	 * @return the val
	 */
	public String getVal() {
		return val;
	}

	/**
	 * Сетва стринговата стойност.
	 *
	 * @param val the new val
	 */
	public void setVal(String val) {
		if(addZeroifDecimalPointfirst == false) { this.val = val; return;}
		this.val = checkDecimalPointPosition(val);
	}
	
	/**
	 * Връща стринг като число.
	 *
	 * @return the as long
	 */
	public  long getAsLong(){
		try{
			return Long.valueOf(val);
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	/**
	 * Връща стринг като число от референтен тип.
	 *
	 * @return the aslong ref
	 */
	public Long getAslongRef(){
		if(val == null)  return null;
		
		try{
			return Long.valueOf(val);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	/**
	 * Връща стринг като число с плаваща запетая.*
	 *
	 * @return the as double
	 */
	public double getAsDouble(){
		try{
			return Double.valueOf(val);
		}catch (Exception e) {
			// TODO: handle exception
			return 0.0;
		}
	}
	
	/**
	 * Връща стрингова стойност.
	 *
	 * @return the as string
	 */
	public String getAsString(){
		return getVal();
	}
	
	/**
	 * Връща дата.
	 *
	 * @param stval the stval
	 * @param format the format
	 * @return the as date
	 */
	public static Date getAsDate(String stval, SimpleDateFormat format){
		try{
			if(stval == null || format == null) return null;
			//SimpleDateFormat daytime = new SimpleDateFormat("yyyy-mm-dd");	
			return format.parse(stval);
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	/**
	 * Връща  BigDecimal от getAsDouble().
	 *
	 * @return the as big decimal double
	 */
	public BigDecimal getAsBigDecimalDouble(){
		try{
			return BigDecimal.valueOf(getAsDouble());
		}catch (Exception e) {
			// TODO: handle exception
			return new BigDecimal(0.0);
		}
	}
	
	/**
	 * Връща  BigDecimal от getAsLong().
	 *
	 * @return the as big decimal long
	 */
	public BigDecimal getAsBigDecimalLong(){
		try{
			return BigDecimal.valueOf(getAsLong());
		}catch (Exception e) {
			// TODO: handle exception
			return new BigDecimal(0);
		}
	}
	
	/**
	 * Цяло число 32 - бита.
	 *
	 * @return the as integer
	 */
	public int getAsInteger(){
		try{
			return Integer.valueOf(val);
		}catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}
	
	/**
	 * Връща стринг като булева стойност.
	 *
	 * @return the as boolean
	 */
	public boolean getAsBoolean(){
		if(getAsLong() == 0)  return false;
		return true;
	}
	
	
	/**
	 * rounds Bigdecimal & sets in val string field.
	 *
	 * @param bd the bd
	 * @param precision the precision
	 * @return the string
	 */
	public String RoundBD(BigDecimal bd, int precision){
		String st = RoundBDSt(bd, precision);
		setVal(st);
		return st;
	}
	
	
	/**
	 * if decimal point is in first place add 0 to string.
	 *
	 * @param in the in
	 * @return the string
	 */
	private String  checkDecimalPointPosition(String in){
		if(in  == null)  return null;
		if(in.indexOf(".") == 0)  return "0"+ in;  
		return in;
	}
	
	/**
	 * round big decimal to n symbols after decimal point & return as String.
	 *
	 * @param bd the bd
	 * @param precision the precision
	 * @return the string
	 */
	public  static String RoundBDSt(BigDecimal bd, int precision) {
		
		if (bd == null)
			return "";
		
		String beforedecimalpoint = "0";
		String afterdecimalpoint = ""; 
		
		//get precision
		for(int i = 0; i < precision; i++){
			afterdecimalpoint += "0";
		}
		
		//form string
		if(!afterdecimalpoint.equals("")) {
			beforedecimalpoint+=".";
			beforedecimalpoint+=afterdecimalpoint;
		}
		
		DecimalFormat df = new DecimalFormat(beforedecimalpoint);
		
		double doublePayment = bd.doubleValue();
		String s = df.format(doublePayment).replace(',', '.');
		return s;
	}
}