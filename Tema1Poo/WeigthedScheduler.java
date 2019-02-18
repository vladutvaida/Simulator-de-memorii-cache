
public class WeigthedScheduler extends Scheduler {
	public WeigthedScheduler(String cachetype, int cachelines, int numberofevents, String[] process, int[] weight,
			int numberofnumbers, int[] numbers) {
		super(cachetype, cachelines, numberofevents, process, weight, numberofnumbers, numbers);
	}
	/**
	 * Afiseaza outputul pe care trebuie sa il afisez in main.
	 *
	 * 
	 */
	public Rezultat[] process() {
        rezultat = new Rezultat[this.getnumberofnumbers()];
		cachememory = new Rezultat[this.getcachelines()];
		int i, j, k, m, l, lastused = 0,timpminim, min = 0,ok = 0,frecmin = 0;
		int contor = 0;
		int n = getnumberofnumbers();
		for (i = 0; i < getnumberofnumbers(); i++)
			rezultat[i] = new Rezultat();
		int suma = 0;
		for (i = 0; i < getnumberofevents(); i++) {
			suma = suma + getweight()[i];
		}
		int x = getweight()[0];
		int y;
		for (i = 1; i < getnumberofevents(); i++) {

			y = getweight()[i];
			while (x != y) {
				if (x > y)
					x = x - y;
				else
					y = y - x;
			}
		}

		i = 0;
		int t = suma / x;
		int[] timp = new int[getcachelines()];
		int[] frec = new int[getcachelines()];
		while (i < getnumberofnumbers()) {
			for (j = 0; j < getnumberofevents(); j++) {
				for (m = 0; m < t * getweight()[j] / suma; m++) {
					if (getprocess()[j].equals("NextPrime")) {
						Process a = new NextPrime(getnumbers()[i]);

						rezultat[i].setnumber(getnumbers()[i]);
						rezultat[i].settip("NextPrime");
						rezultat[i].setresult(a.result());
						if (getcachetype().equals("NoCache"))
							rezultat[i].setcache("Computed");

						else if(getcachetype().equals("LruCache")){
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("NextPrime")) {
										rezultat[i].setcache("FromCache");
										timp[k] = i;
										ok = 1;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									timp[contor] = i;
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
							
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("NextPrime")) {
											rezultat[i].setcache("FromCache");
											timp[k] = i;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										timpminim = timp[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (timp[k] < timpminim) {
												timpminim = timp[k];
												min = k;
											}
										}
										timp[min] = i;
										cachememory[min] = rezultat[i];
									}
								}
							}
						else
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("NextPrime")) {
										rezultat[i].setcache("FromCache");
										frec[k]++;
										ok = 1;
										break;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("NextPrime")) {
											rezultat[i].setcache("FromCache");
											frec[k]++;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										frecmin = frec[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (frec[k] < frecmin) {
												frecmin = frec[k];
												min = k;
											}
										}
										frec[min] = 0;
										cachememory[min] = rezultat[i];
									}
								}
							

						}
						
					} else if (getprocess()[j].equals("Fibonacci")) {
						Process a = new Fibonacci(getnumbers()[i]);
					
						rezultat[i].setnumber(getnumbers()[i]);
						rezultat[i].settip("Fibonacci");
						rezultat[i].setresult(a.result());
						if (getcachetype().equals("NoCache"))
							rezultat[i].setcache("Computed");
						else if(getcachetype().equals("LruCache")){
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Fibonacci")) {
										rezultat[i].setcache("FromCache");
										timp[k] = i;
										ok = 1;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									timp[contor] = i;
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
						
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Fibonacci")) {
											rezultat[i].setcache("FromCache");
											timp[k] = i;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										timpminim = timp[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (timp[k] < timpminim) {
												timpminim = timp[k];
												min = k;
											}
										}
										timp[min] = i;
										cachememory[min] = rezultat[i];
									}
								}
							}
						else
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Fibonacci")) {
										rezultat[i].setcache("FromCache");
										frec[k]++;
										ok = 1;
										break;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Fibonacci")) {
											rezultat[i].setcache("FromCache");
											frec[k]++;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										frecmin = frec[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (frec[k] < frecmin) {
												frecmin = frec[k];
												min = k;
											}
										}
										frec[min] = 0;
										cachememory[min] = rezultat[i];
									}
								}
							

						}

						
					} else if (getprocess()[j].equals("Cube")) {
						Process a = new Cube(getnumbers()[i]);

						rezultat[i].setnumber(getnumbers()[i]);
						rezultat[i].settip("Cube");
						rezultat[i].setresult(a.result());
						if (getcachetype().equals("NoCache"))
							rezultat[i].setcache("Computed");
						else if(getcachetype().equals("LruCache"))
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Cube")) {
										rezultat[i].setcache("FromCache");
										timp[k] = i;
										ok = 1;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									timp[contor] = i;
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
							
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Cube")) {
											rezultat[i].setcache("FromCache");
											timp[k] = i;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										timpminim = timp[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (timp[k] < timpminim) {
												timpminim = timp[k];
												min = k;
											}
										}
										timp[min] = i;
										cachememory[min] = rezultat[i];
									}
								}
							}
						else
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Cube")) {
										rezultat[i].setcache("FromCache");
										frec[k]++;
										ok = 1;
										break;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Cube")) {
											rezultat[i].setcache("FromCache");
											frec[k]++;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										frecmin = frec[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (frec[k] < frecmin) {
												frecmin = frec[k];
												min = k;
											}
										}
										frec[min] = 0;
										cachememory[min] = rezultat[i];
									}
								}
							

						}
						
						
					} else if (getprocess()[j].equals("Square")) {
						Process a = new Square(getnumbers()[i]);

						rezultat[i].setnumber(getnumbers()[i]);
						rezultat[i].settip("Square");
						rezultat[i].setresult(a.result());
						if (getcachetype().equals("NoCache"))
							rezultat[i].setcache("Computed");
						else if(getcachetype().equals("LruCache"))
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Square")) {
										rezultat[i].setcache("FromCache");
										timp[k] = i;
										ok = 1;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									timp[contor] = i;
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Square")) {
											rezultat[i].setcache("FromCache");
											timp[k] = i;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										timpminim = timp[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (timp[k] < timpminim) {
												timpminim = timp[k];
												min = k;
											}
										}
										timp[min] = i;
										cachememory[min] = rezultat[i];
									}
								}
							}
						else
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Square")) {
										rezultat[i].setcache("FromCache");
										frec[k]++;
										ok = 1;
										break;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Square")) {
											rezultat[i].setcache("FromCache");
											frec[k]++;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										frecmin = frec[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (frec[k] < frecmin) {
												frecmin = frec[k];
												min = k;
											}
										}
										frec[min] = 0;
										cachememory[min] = rezultat[i];
									}
								}
							

						}

						
						
					} else if (getprocess()[j].equals("Sqrt")) {
						Process a = new Sqrt(getnumbers()[i]);
						rezultat[i].setnumber(getnumbers()[i]);
						rezultat[i].settip("Sqrt");
						rezultat[i].setresult(a.result());
						if (getcachetype().equals("NoCache"))
							rezultat[i].setcache("Computed");
						else if(getcachetype().equals("LruCache"))
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Sqrt")) {
										rezultat[i].setcache("FromCache");
										timp[k] = i;
										ok = 1;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									timp[contor] = i;
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Sqrt")) {
											rezultat[i].setcache("FromCache");
											timp[k] = i;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										timpminim = timp[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (timp[k] < timpminim) {
												timpminim = timp[k];
												min = k;
											}
										}
										timp[min] = i;
										cachememory[min] = rezultat[i];
									}
								}
							}
						else
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Sqrt")) {
										rezultat[i].setcache("FromCache");
										frec[k]++;
										ok = 1;
										break;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Sqrt")) {
											rezultat[i].setcache("FromCache");
											frec[k]++;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										frecmin = frec[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (frec[k] < frecmin) {
												frecmin = frec[k];
												min = k;
											}
										}
										frec[min] = 0;
										cachememory[min] = rezultat[i];
									}
								}
							

						}
							
							
						
						
					} else if (getprocess()[j].equals("CheckPrime")) {
						Process a = new CheckPrime(getnumbers()[i]);

						rezultat[i].setnumber(getnumbers()[i]);
						rezultat[i].settip("CheckPrime");
						rezultat[i].setresult(a.result());
						if (getcachetype().equals("NoCache"))
							rezultat[i].setcache("Computed");
						else if(getcachetype().equals("LruCache"))
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("CheckPrime")) {
										rezultat[i].setcache("FromCache");
										timp[k] = i;
										ok = 1;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									timp[contor] = i;
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else  {
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("CheckPrime")) {
											rezultat[i].setcache("FromCache");
											timp[k] = i;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										timpminim = timp[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (timp[k] < timpminim) {
												timpminim = timp[k];
												min = k;
											}
										}
										timp[min] = i;
										cachememory[min] = rezultat[i];
									}
								}
							}
						else
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("CheckPrime")) {
										rezultat[i].setcache("FromCache");
										frec[k]++;
										ok = 1;
										break;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("CheckPrime")) {
											rezultat[i].setcache("FromCache");
											frec[k]++;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										frecmin = frec[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (frec[k] < frecmin) {
												frecmin = frec[k];
												min = k;
											}
										}
										frec[min] = 0;
										cachememory[min] = rezultat[i];
									}
								}
							

						}
						
						
					} else if (getprocess()[j].equals("Factorial")) {
						Process a = new Factorial(getnumbers()[i]);

						rezultat[i].setnumber(getnumbers()[i]);
						rezultat[i].settip("Factorial");
						rezultat[i].setresult(a.result());
						if (getcachetype().equals("NoCache"))
							rezultat[i].setcache("Computed");
						else if(getcachetype().equals("LruCache"))
						{
							ok = 0;
							if (contor < this.getcachelines()) {
								for (k = 0; k < contor; k++) {
									if (cachememory[k].getnumber() == rezultat[i].getnumber()
											&& cachememory[k].gettip().equals("Factorial")) {
										rezultat[i].setcache("FromCache");
										timp[k] = i;
										ok = 1;
									}
								}
								if (ok == 0) {
									rezultat[i].setcache("Computed");
									timp[contor] = i;
									cachememory[contor] = rezultat[i];
									contor++;
								}

							} else {
								
									for (k = 0; k < this.getcachelines(); k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Factorial")) {
											rezultat[i].setcache("FromCache");
											timp[k] = i;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										timpminim = timp[0];
										min = 0;
										for (k = 1; k < this.getcachelines(); k++) {
											if (timp[k] < timpminim) {
												timpminim = timp[k];
												min = k;
											}
										}
										timp[min] = i;
										cachememory[min] = rezultat[i];
									}
							    }
							}
							else
							{
								ok = 0;
								if (contor < this.getcachelines()) {
									for (k = 0; k < contor; k++) {
										if (cachememory[k].getnumber() == rezultat[i].getnumber()
												&& cachememory[k].gettip().equals("Factorial")) {
											rezultat[i].setcache("FromCache");
											frec[k]++;
											ok = 1;
											break;
										}
									}
									if (ok == 0) {
										rezultat[i].setcache("Computed");
										cachememory[contor] = rezultat[i];
										contor++;
									}

								} else {
									
										for (k = 0; k < this.getcachelines(); k++) {
											if (cachememory[k].getnumber() == rezultat[i].getnumber()
													&& cachememory[k].gettip().equals("Factorial")) {
												rezultat[i].setcache("FromCache");
												frec[k]++;
												ok = 1;
												break;
											}
										}
										if (ok == 0) {
											rezultat[i].setcache("Computed");
											frecmin = frec[0];
											min = 0;
											for (k = 1; k < this.getcachelines(); k++) {
												if (frec[k] < frecmin) {
													frecmin = frec[k];
													min = k;
												}
											}
											frec[min] = 0;
											cachememory[min] = rezultat[i];
										}
									}
								

							
						}
						
					}
					i++;

					if (i == getnumberofnumbers())
						break;
				}
				if (i == getnumberofnumbers())
					break;
			}
			if (i == getnumberofnumbers())
				break;

		}
		return rezultat;
	}

}
