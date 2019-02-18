

public class Cube extends Process{
	public Cube(int n)
	{
		super(n);
	}
	@Override
	public String result()
	{
		return String.valueOf(n * n * n);
	}
}
