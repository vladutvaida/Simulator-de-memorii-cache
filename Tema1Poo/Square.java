
public class Square extends Process{
	public Square(int n)
	{
		super(n);
	}
	@Override
	public String result()
	{
		return String.valueOf(n * n);
	}
}
