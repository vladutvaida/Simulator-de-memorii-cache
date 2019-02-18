
	public class Sqrt extends Process{
		public Sqrt(int n)
		{
			super(n);
		}
		@Override
		public String result()
		{
			double x = Math.floor(Math.sqrt(Math.abs(n)));
			return String.valueOf((int)x);
		}

	}

