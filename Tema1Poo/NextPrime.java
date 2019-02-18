
public class NextPrime extends Process{
	public NextPrime(int n)
	{
		super(n);
	}
	@Override
	public String result()
	{
		int ok = 0;
		if(n < 1)
		{
			n = 2;
			ok = 1;
		}
		while(ok == 0)
		{	n++;
			for(int i = 2;i <= n / 2;i ++)
			{
				if(n % i == 0)
					ok = 1;
			}
			if(ok == 1)
				ok = 0;
			else ok = 1;
		}
		return String.valueOf(n);
	}
}
