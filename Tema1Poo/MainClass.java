
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class MainClass {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File(args[0]));
		PrintWriter print = new PrintWriter(new File(args[1]));

		String cachetype = s.nextLine();

		int cachelines = s.nextInt();
		s.nextLine();

		String schedulertype = s.nextLine();
		int numberofevents = s.nextInt();
		s.nextLine();
		String[] process = new String[numberofevents];
		int[] weights = new int[numberofevents];
		int i;
		for (i = 0; i < numberofevents; i++) {
			String[] tmp = s.nextLine().trim().split(" ");
			process[i] = tmp[0];
			weights[i] = Integer.parseInt(tmp[1]);
		}

		int numberofnumbers = s.nextInt();
		Rezultat[] rezultat1 = new Rezultat[numberofnumbers];
		Rezultat[] rezultat2 = new Rezultat[numberofnumbers];
		Rezultat[] rezultat3 = new Rezultat[numberofnumbers];
		int[] numbers = new int[numberofnumbers];
		for (i = 0; i < numberofnumbers; i++) {
			numbers[i] = s.nextInt();

		}
		RandomScheduler scheduler1 = null;
		WeigthedScheduler scheduler2 = null;
		RoundRobinScheduler scheduler3 = null;
		if(schedulertype.equals("RandomScheduler"))
		{	scheduler1 = new RandomScheduler(cachetype, cachelines, numberofevents, process, weights,numberofnumbers, numbers);
			rezultat1 = scheduler1.process();
			for (i = 0; i < scheduler1.getnumberofnumbers(); i++) {
				print.write(rezultat1[i].getnumber() + " ");
				print.write(rezultat1[i].gettip() + " ");
				print.write(rezultat1[i].getresult() + " ");
				print.write(rezultat1[i].getcache() + "\n");
			}
			print.close();
		
		}	
		if(schedulertype.equals("WeightedScheduler"))
		{	scheduler2 = new WeigthedScheduler(cachetype, cachelines, numberofevents, process, weights,numberofnumbers, numbers);
			rezultat2 = scheduler2.process();
			for (i = 0; i < scheduler2.getnumberofnumbers(); i++) {
				print.write(rezultat2[i].getnumber() + " ");
				print.write(rezultat2[i].gettip() + " ");
				print.write(rezultat2[i].getresult() + " ");
				print.write(rezultat2[i].getcache() + "\n");
			}
			print.close();
			
		
		}		
		if(schedulertype.equals("RoundRobinScheduler"))
		{	scheduler3 = new RoundRobinScheduler(cachetype, cachelines, numberofevents, process, weights,numberofnumbers, numbers);
			rezultat3 = scheduler3.process();
			for (i = 0; i < scheduler3.getnumberofnumbers(); i++) {
				print.write(rezultat3[i].getnumber() + " ");
				print.write(rezultat3[i].gettip() + " ");
				print.write(rezultat3[i].getresult() + " ");
				print.write(rezultat3[i].getcache() + "\n");
			}
			print.close();
			
		
		}	
		
	}
}
