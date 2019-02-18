
public class CheckPrime extends Process{
	public CheckPrime(int n)
	{
		super(n);
	}
	@Override
	public String result()
	{
		int i;
		if(n < 2)
			return "0";
		for(i = 2;i <= n / 2;i ++)
		{
			if(n % i == 0)
				return "0";
		}
		return "1";
	}
}
