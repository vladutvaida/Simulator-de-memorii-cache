
public class Rezultat {
	private int number;
	private String tip;
	private String result;
	private String cache;
	public Rezultat()
	{
		
		
	}/**
	 * Seteaza numarul.
	 */
	public void setnumber(int number)
	{
		this.number = number;
	}
	/**
	 * Seteaza tipul procesulu.
	 */
	public void settip(String tip)
	{
		this.tip = tip;
	}
	/**
	 * Seteaza rezultatul.
	 */
	public void setresult(String result)
	{
		this.result = result;
	}
	/**
	 * Seteaza cacheul.
	 */
	public void setcache(String cache)
	{
		this.cache = cache;
	}
	/**
	 * Returneaza numarul.
	 */
	public int getnumber()
	{
		return number;
	}
	/**
	 * Returneaza tipul procesului.
	 */
	public String gettip()
	{
		return tip;
	}
	/**
	 * Returneaza rezultatului.
	 */
	public String getresult()
	{
		return result;
	}
	/**
	 * Returneaza cacheul.
	 */
	public String getcache()
	{
		return cache;
	}
}
