
import java.io.*;
public class Scheduler {
	private String cachetype;
	private int cachelines;
	private int numberofevents;
	private String[] process;
	private int[] weight;
	private int numberofnumbers;
	private int[] numbers;
	protected int contor;
	protected String[] cache;
	protected int[] timp;
	protected int[] frec;
	Rezultat[] rezultat;
	Rezultat[] cachememory;
	/**
	 * Initializeaza schedulerul.
	 *
	 * 
	 */
	public Scheduler(String cachetype,int cachelines,int numberofevents,String[] process,int[] weight,int numberofnumbers,int[] numbers)
	{
		this.cachetype = cachetype;
		this.cachelines = cachelines;
		this.numberofevents = numberofevents;
		this.process = process;
		this.weight = weight;
		this.numberofnumbers = numberofnumbers;
		this.numbers = numbers;
		this.contor = 0;
	}/**
	 * Returneaza tipul cacheului ,daca acesta exista.
	 *
	 * 
	 */
	public String getcachetype()
	{
		return cachetype;
	}
	/**
	 * Returneaza numarul de evenimente.
	 */
	public int getnumberofevents()
	{
		return numberofevents;
	}/**
	 * Returneaza numarul de linii din cache.
	 */
	public int getcachelines()
	{
		return cachelines;
	}
	/**
	 * Returneaza tipul procesului.
	 */
	public String[] getprocess()
	{
		return process;
	}
	/**
	 * Returneaza cota procesului.
	 */
	public int[] getweight()
	{
		return weight;
	}
	/**
	 * Returneaza numarul de numere.
	 */
	public int getnumberofnumbers()
	{
		return numberofnumbers;
	}
	/**
	 * Returneaza vectorul de numere.
	 */
	public int[] getnumbers()
	{
		return numbers;
	}
	/**
	 * Setter pentru numarul numerelor.
	 */
	public void setnumberofnumbers(int numberofnumbers)
	{
		this.numberofnumbers = numberofnumbers;
	}
	/**
	 * Returneaza vectorul de rezultate.
	 */
	public Rezultat[] process()
	{
		Rezultat[] rezultat= new Rezultat[2];
		return rezultat;
	}
	/**
	 * Setter pentru contor.
	 */
	public void setcontor(int contor)
	{
		this.contor = contor;
	}
	/**
	 * Getter pentru contor.
	 */
	public int getcontor()
	{
		return contor;
	}
	
}
