package tgm.sew.hit.roboterfabrik;

import java.util.LinkedList;

/**
 * Created by Patrick on 29.09.14.
 */
public class Controller {

	public static void main(String[] args) {


		new New_CLI(args).parse();

		//changessss
		LinkedList<Monteur> monteurLinkedList = new LinkedList<Monteur>();
		Sekretariat sekretariat = new Sekretariat(Controller.getAnzahlMonteure(args));
		 //logverzeichnis(commandlineinterface.getLager());

		Lagermitarbeiter lagermit = new Lagermitarbeiter(Controller.getLagerVerzeichnis(args));
		Lieferant lieferant = new Lieferant(Controller.getLagerVerzeichnis(args));
		System.out.print("schlafen start");
		TimerWD timer= new TimerWD(Controller.getLaufzeit(args));
		System.out.print("schlafen ende");


		int[] ids = sekretariat.getUniqueIDs();

		System.out.println(Controller.getLagerVerzeichnis(args));
		System.out.println(Controller.getAnzahlLieferanten(args));
		System.out.println(Controller.getAnzahlMonteure(args));
		System.out.println(Controller.getLaufzeit(args));

		lieferant.liefern(Controller.getAnzahlLieferanten(args));
		System.out.println("nach lieferant");
		lagermit.readFile();
		System.out.print("nachreadfile");
		for(int i = 0;i<Controller.getAnzahlMonteure(args);i++){
			System.out.print("ersteforschleife"+i);
			monteurLinkedList.add(new Monteur(ids[i]));
			monteurLinkedList.get(i).start();
			monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
			monteurLinkedList.get(i).bauen(sekretariat.getId());
		}
		int k = 0;
		do {
			System.out.println(k);
			k++;
			lieferant.liefern(Controller.getAnzahlLieferanten(args));
			for (int i = 0; i < Controller.getAnzahlMonteure(args); i++) {
				Roboter fertigrobo = monteurLinkedList.get(i).getRoboter();
				lagermit.writeFile(fertigrobo);
				monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
				monteurLinkedList.get(i).bauen(sekretariat.getId());
				System.out.println("For schleife" + i);
			}
		}while( timer.tokeepRunning() == true);
	}

	private static String getLagerVerzeichnis(String[] args){
		String lager= "--lager";
		for(int i = 0;i<args.length;i++){
			if(lager.equals(args[i])){
				return args[i+1];
			}

		}
		return "fehler";

	}

	private static int getAnzahlLieferanten(String[] args){
		String lieferanten= "--lieferanten";
		for(int i = 0;i<args.length;i++){
			if(lieferanten.equals(args[i])){
				return Integer.parseInt(args[i+1]);
			}

		}
		return 0;

	}
	private static int getAnzahlMonteure(String[] args){
		String monteure= "--monteure";
		for(int i = 0;i<args.length;i++){
			if(monteure.equals(args[i])){
				return Integer.parseInt(args[i+1]);
			}

		}
		return 0;

	}
	private static int getLaufzeit(String[] args){
		String laufzeit= "--laufzeit";
		for(int i = 0;i<args.length;i++){
			if(laufzeit.equals(args[i])){
				return Integer.parseInt(args[i+1]);
			}

		}
		return 0;

	}
}
