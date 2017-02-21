/**
 * 
 * @author Sascha Obst
 * @version 1.0
 * 
 */

public class MathUtil {
	
	// greatest common divisor (Größten gemeinsamer Teiler)
	
	public static int ggt(int a, int b) {

		int x = a;
		int y = b;
		
		if (x == 0) {
			
			return y;
		} else {
			
			while (y != 0) {
				
				if (x > y) {
					
					x = x-y;
				} else {
					
					y = y-x;
				}
			}
			
			return x;
		}

		
	}
	
	// Least common multiple (Kleinstes gemeinsames Vielfaches)
	
	public static int kgv(int a, int b) {
		
		int x = Math.abs(a * b) / ggt(a, b);
		return x;
	}
	
	// prime factorization (Primfaktorzerlegung)
	
	public static void pf(long a) {
		
	        long i;
	        long max;
	        max = (long) Math.round(Math.sqrt((double) a));
	        
	        if (a <= 1) {
	      return;
	    }
	        
	        if (a%2 == 0) {
	            System.out.print("2*");
	            pf(a/2);
	            return;
	        }
	        
	        for (i=3; i<=max; i=i+2) {
	        
	            if (a%i == 0) {
	                pf(i);
	                pf(a/i);
	                
	                return;
	            }
	        }
	        System.out.print(a + "*");
	}
	
	
	// euclidean algorithm (Euklidischer Algorithmus)
	
	public static void euklid(int a, int b) {
		
		int x = a;
		int y = b;
		int q, r;
		r = 1;
		
		if (x == y) {
			System.out.println("Nichts zu berechnen! " + x + " ist ggT.");	
			return;	
		}
		
		if (x < y) {
			x = b;
			y = a;
		}
		
		while (r != 0) {
			q = x/y;
			r = x%y;
			System.out.println(x + " = " + y + "*" + q + "+" + r);
			x = y;
			y = r;
		}
		
		System.out.println("ggT ist der letzte Rest grösser 0 also " + ggt(a, b));
		
	}
	
	// Ulam conjecture (Ulam-Funktion)
	
	public static int ulam(int n) {
		
		System.out.println("ulam(" + n + ") = ");
		
		if (n == 1) {
			
			System.out.println("1");
			return 1;
		} else {
			
			if (n % 2 == 0) {
				
				return ulam(n/2);
			}
		}
		return ulam(3*n+1);
	}
	
	// chinese remainder theorem (Chinesischer Restsatz)
	
	public static int chin(int[] reste, int[] module) {
		
		int m = 0;
		int[] n = new int[module.length];
		
		if (module.length >= 2) {
			m = module[0] * module[1];
			
			for (int i = 2; i < module.length; i++) {
				
				m *= module[i];
			}
		} else {
			System.out.println("Fehler: Mindestens zwei Kongruenzen benötigt");
		}
		
		 
		for (int j = 0; j < module.length; j++) {
			
			n[j] = m / module[j];
			System.out.println("M"+ j + " = " + n[j]);
		}
		
		return m;
	}
	
	// addtion table modulo x (Additionstabelle modulo x)
	
	public static void createAddTab(int modul) {
		
		System.out.println("Additionstabelle modulo " + modul);
		System.out.print("+ ");
		
		for (int i = 0; i < modul; i++) {
			
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (int j = 0; j < modul; j++) {
		
			System.out.print(j + " ");
			
			for (int k = 0; k < modul; k++) {
				
				System.out.print((j + k) % modul + " ");
			}
			System.out.println();
		}
	}
	
	// coprime integers (auf Teilerfemdheit prüfen)
	
	public static boolean teilerfremd(int a, int b) {
		
		if (ggt(a, b) == 1) {
			
			return true;
		} else
			return false;
	}
	
	//multiplication table modulo x (Multiplikationstabelle modulo x)
	
	public static void createMulTab(int modul) {
		
		System.out.println("Multiplikationstabelle modulo " + modul);
		System.out.print("* ");
		
		for (int i = 1; i < modul; i++) {
			
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (int j = 1; j < modul; j++) {
		
			System.out.print(j + " ");
			
			for (int k = 1; k < modul; k++) {
				
				System.out.print((j * k) % modul + " ");
			}
			System.out.println();
		}
	}
	
	// boolean array are all indexes true? (boolean array prüfen ob alle Indizes wahr)
	
	public static boolean areAllTrue(boolean[] array)
	{
	    for(boolean b : array) if(!b) return false;
	    return true;
	}
	
	// cyclic group (zyklische Untergruppe modulo x)
	
	public static int[] zGruppe(int modul, int i) {
			
			if (teilerfremd(i, modul)) {
				
				int[] untergruppe;
				int j = 0;
				do {
					
					j++;
					
				} while (Math.pow(i, j) % modul != 1);
				
				untergruppe = new int[j];
				
				j = 0;
				do {
					
					untergruppe[j] = (int)(Math.pow(i, j) % modul);
					j++;
				} while (Math.pow(i, j) % modul != 1);
				
				return untergruppe;
			} else return null;
		
	}
	
	// all cyclic groups modulo x (alle zyklischen Untergruppen modulo modul)
	
	public static void zykGruppe(int modul) {
		
		System.out.println("Zyklische Untergruppen modulo " + modul + ":");
		
		for (int i = 1; i < modul; i++) {
			
			if (teilerfremd(i, modul)) {
			
				System.out.print("<" + i + "> = {");
				
				boolean[] generatorArray = new boolean[modul];
				generatorArray[0] = true;
				
				int j = 0;
				do {
					generatorArray[(int)(Math.pow(i, j) % modul)] = true;
					System.out.print((int)(Math.pow(i, j) % modul) + " ");
					j++;
					
				} while (Math.pow(i, j) % modul != 1);
				System.out.print("}");
				
				if (areAllTrue(generatorArray)) {
					
					System.out.print(" -> Generator");
				}
				
				System.out.println();	
			}
		}
	}
	
	// alle Links- und Rechtsnebenklassen
	public static void nebenklasse(int modul, int a) {
		
		if (teilerfremd(modul, a)) {
			for (int i = 1; i < modul; i++) {
				
				System.out.print(i + " * <" + a + "> = {");
				
				for (int b: MathUtil.zGruppe(modul, a)) {
					
					System.out.print((i * b) % modul + " ");
				}
				System.out.print("}  ");
				
				System.out.print("<" + a + "> * " + i +" = {");
				
				for (int b: MathUtil.zGruppe(modul, a)) {
					
					System.out.print((b * i) % modul + " ");
				}
				System.out.print("}\n");
			}
			
			
		} else System.out.println("Fehler: <" + a + ">" + " ist keine zykl. Untergruppe von " + modul);	
	}
	
	// Euler's totient function (Eulersche Phi-Funktion)
	
	public static int eulerphi(int n) {
		
		int zaehler = 0;
		
		for (int i = 0; i < n; i++) {
			
			if (ggt(i, n) == 1) {
				
				zaehler++;
			}
		}
		
		return zaehler;
	}
	
	// sieve of Eratosthenes (Sieb des Eratosthenes)
	
	public static boolean[] eratosthenes(int n) {
		
		boolean[] sieb = new boolean[n+1];
		
		for (int i = 2; i <= n; i++) {
			
			sieb[i] = true;
		}
		
		for (int j = 2; j <= Math.sqrt(n); j++) {
			
			if (sieb[j] == true) {
				
				for (int k = j; k <= (n/j); k++) {
					
					sieb[j*k] = false; 
				}
			}
		}
		
		return sieb;
	}
	
	
	// recursive factorial (rekursive Fakultaetsfunktion)
	
	public static int fakultaet(int n) {
		
		if (n == 0) {
			
			return 1;
		}
		
		return n * fakultaet(n-1);
	}
	
	
	// Wilson's theorem (Satz von Wilson (Primzahltest))
	
	public static boolean wilson(int p) {
		
		if (p >= 2) {
			
			if ((MathUtil.fakultaet(p-1)+1) % p == 0) {
				
				return true;
			}
			
			return false;
			
		} else
		{
			System.out.println("Zahl muss groesser oder gleich 2 sein");
			return false;
		}
	}
	
	// Fermat's little theorem (Kleiner fermatscher Satz)
	
	public static boolean fermat(int k) {
		
		int a = (int)(Math.random() * (k-1) + 1);
		
		if (Math.pow(a, k-1) % k != 1) {
			
			return false;
		} else {
			
			return true;
		}
		
	}
}
	
