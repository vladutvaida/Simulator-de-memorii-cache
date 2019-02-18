

public class Fibonacci extends Process{
	public Fibonacci(int n)
	{
		super(n);
	}
	@Override
	public String result()
	{
		int a = 1;
		int b = 1;
		int c = 0;
		if(n < 0)
			return "-1";
		else if (n == 0)
			return "0";
		else if(n == 1) 
			return "1";
		else if(n == 2)
			return "1";
		else
		{
			for(int i = 3;i <= n; i ++)
			{
				c = (a + b) % 9973;
				a = b % 9973;
				b = c;
			}
			return String.valueOf(c);
		}
	}
}
