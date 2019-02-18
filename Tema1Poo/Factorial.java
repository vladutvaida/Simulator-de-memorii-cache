
public class Factorial extends Process{
	public Factorial(int n)
	{
		super(n);
	}
	@Override
	public String result()
	{
		int fact = 1;
		if(n < 0)
			return "0";
		else if(n == 0)
			return "1";
		else
		{
			for(int i = 1;i <= n;i ++)
				fact = (fact * i) % 9973;
			return String.valueOf(fact);
		}
	}
}
