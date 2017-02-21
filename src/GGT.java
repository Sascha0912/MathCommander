/**
 * 
 * @author Sascha Obst
 * @version 1.0
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GGT {

	private static CommandHandler handler;
	private static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);
		
		
		System.out.println("Geben Sie einen Befehl ein:");
		System.out.println("Für Hilfe schreiben Sie >help<");
		
		    
		
		handler = new CommandHandler();
		handler.addCommand("ggt", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				System.out.println("Geben Sie zwei Zahlen ein:");
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				
				System.out.println("ggt(" + x + ", " + y + ") =");
				System.out.println(MathUtil.ggt(x, y));
				
				System.out.println("... ist der grösste gemeinsame Teiler.");
				
				if (MathUtil.ggt(x, y) == 1) {
					
					System.out.println("... die eingegebenen Zahlen sind teilerfremd.");
				}
			}
		});
		
		
		
		
		handler.addCommand("kgv", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				System.out.println("Geben Sie zwei Zahlen ein:");
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				
				System.out.println("kgv(" + x + ", " + y + ") =");
				System.out.println(MathUtil.kgv(x, y));
				
				System.out.println("... ist das kleinste gemeinsame Vielfache.");
			}	
		});
		
		handler.addCommand("help", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				File file = new File("src/help.txt");
				
				try {
					
					Scanner sc = new Scanner(file);
					while (sc.hasNextLine()) {
						String s = sc.nextLine();
						System.out.println(s);
					}
					sc.close();
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
			}	
		});
		
		handler.addCommand("pf", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				System.out.println("Geben Sie eine Zahl ein, die in ihre Primfaktoren zerlegt werden soll:");
				long x = scanner.nextLong();
				
				//long time = System.currentTimeMillis();
				MathUtil.pf(x);
				//long time1 = System.currentTimeMillis();
				//long time2 = time - time1;
				//System.out.println(time2);
			}	
		});
		
		handler.addCommand("euklid", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				System.out.println("Geben Sie zwei Zahlen ein:");
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				
				MathUtil.euklid(x, y);
			}	
		});
		
		handler.addCommand("ulam", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie eine Zahl ein:");
				int n = scanner.nextInt();
				
				MathUtil.ulam(n);
				
			}
		});
		
		handler.addCommand("chin", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Anzahl Kongruenzen:");
				int n = scanner.nextInt();
				
				int[] reste = new int[n];
				int[] module = new int[n];
				
				for (int i = 0; i < n; i++) {
					
					System.out.println("Rest x? modulo y?");
					reste[i] = scanner.nextInt();
					module[i] = scanner.nextInt();
				}
				
				System.out.println(MathUtil.chin(reste, module));
				
			}
		});
		
		handler.addCommand("addtab", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie das Modul ein:");
				int n = scanner.nextInt();
				
				MathUtil.createAddTab(n);
				
			}
		});
		
		handler.addCommand("multab", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie das Modul ein:");
				int n = scanner.nextInt();
				
				MathUtil.createMulTab(n);
				
			}
		});
		
		handler.addCommand("zykgr", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie das Modul ein:");
				int n = scanner.nextInt();
				
				MathUtil.zykGruppe(n);
				
			}
		});
		
		handler.addCommand("nebkl", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie das Modul und <?> an");
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				
				MathUtil.nebenklasse(n, m);
				
			}
		});
		
		handler.addCommand("eulerphi", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie n an:");
				
				try {
					
					int n = scanner.nextInt();
					System.out.println(MathUtil.eulerphi(n));
				} catch (InputMismatchException e) {
					
					System.out.println("Falsche Parameter!");
				} catch (Exception e) {
					
					System.out.println("Unbekannter Fehler!");
				}
			}
		});
		
		handler.addCommand("eratos", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie n an:");
				
				try {
					
					int n = scanner.nextInt();
					int zaehler = 0;
					
					for (boolean wert : MathUtil.eratosthenes(n)) {
						
						System.out.println(zaehler + " prim? " + wert);
						zaehler++;
					}
				
				} catch (InputMismatchException e) {
					
					System.out.println("Falsche Parameter!");
				} catch (Exception e) {
					
					System.out.println("Unbekannter Fehler!");
				}
								
			}
		});
		
		handler.addCommand("fak", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie n an:");
				
				try {
					int n = scanner.nextInt();
					System.out.println(MathUtil.fakultaet(n));
				} catch (InputMismatchException e) {
					
					System.out.println("Falsche Parameter!");
				} catch (Exception e) {
					
					System.out.println("Unbekannter Fehler!");
				}
				
				
				
				
			}
		});
		
		handler.addCommand("wilson", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie n an:");
				
				try {
					int n = scanner.nextInt();
					
					if (MathUtil.wilson(n)) {
						
						System.out.println(n + " ist nach dem Wilson-Test prim");
					} else
					{
						System.out.println(n + " ist nach dem Wilson-Test nicht prim");
					}
				} catch (InputMismatchException e) {
					
					System.out.println("Falsche Parameter!");
				} catch (Exception e) {
					
					System.out.println("Unbekannter Fehler!");
				}
				
			}
		});
		
		handler.addCommand("fermat", new IfCommandInput() {
			
			@Override
			public void ausfuehren(String eingabe) {
				
				System.out.println("Geben Sie n an:");
				
				try {
					int n = scanner.nextInt();
					
					if (MathUtil.fermat(n)) {
						
						System.out.println(n + " ist nach dem Fermat-Test prim");
					} else
					{
						System.out.println(n + " ist nach dem Fermat-Test nicht prim");
					}
				} catch (InputMismatchException e) {
					
					System.out.println("Falsche Parameter!");
				} catch (Exception e) {
					
					System.out.println("Unbekannter Fehler!");
				}
				
			}
		});
		
		
		run();

		scanner.close();
	}
	
	
	public static void run(){
		String command = scanner.next();
		if (!command.equalsIgnoreCase("exit")) {
			Command c = handler.findCommand(command);
			if (c != null){
				c.ausfuehren(command);
			} else {
				System.out.println("Command " + command + " not found!");
			}
			run();
		}
	}
	
	public static int ganzeZahlEinlesen() {
		
		Scanner sc = new Scanner(System.in);
		int x = 0;
		
		try {
			
			x = sc.nextInt();
			sc.close();
			return x;
			
		} catch (InputMismatchException e) {
			
			System.out.println("Falsche Eingaben!");
		} catch (Exception e) {
			
			System.out.println("Unbekannter Fehler!");
		}
		
		sc.close();
		return x;
	}
	

}
