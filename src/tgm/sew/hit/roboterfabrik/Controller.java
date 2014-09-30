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
		TimerWD timer= new TimerWD(Controller.getLaufzeit(args));



		int[] ids = sekretariat.getUniqueIDs();
		/*
		System.out.println(test.getLager());
		System.out.println(test.getZeit());
		System.out.println(test.getLieferant());
		System.out.println(test.getMonteure());
		*/
		lieferant.liefern(Controller.getAnzahlLieferanten(args));
		for(int i = 0;i<Controller.getAnzahlMonteure(args);i++){
			monteurLinkedList.add(new Monteur(ids[i]));
			monteurLinkedList.get(i).start();
			monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
			monteurLinkedList.get(i).bauen(sekretariat.getId());
		}

		do {
			lieferant.liefern(Controller.getAnzahlLieferanten(args));
			for (int i = 0; i < Controller.getAnzahlMonteure(args); i++) {
				Roboter fertigrobo = monteurLinkedList.get(i).getRoboter();
				lagermit.writeFile(fertigrobo);
				monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
				monteurLinkedList.get(i).bauen(sekretariat.getId());
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
