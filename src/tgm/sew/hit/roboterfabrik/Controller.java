package tgm.sew.hit.roboterfabrik;

import java.util.LinkedList;

/**
 * Created by Patrick on 29.09.14.
 */
public class Controller {

	public static void main(String[] args) {
		CLI commandlineinterface = new CLI();
		LinkedList<Monteur> monteurLinkedList = new LinkedList<Monteur>();
		int[] a = new int[6];
		 //logverzeichnis(commandlineinterface.getLager());

		Lagermitarbeiter lagermit = new Lagermitarbeiter(commandlineinterface.getLager());
		Lieferant lieferant = new Lieferant(commandlineinterface.getLieferant());


		for(int i = 0;i<commandlineinterface.getMonteur()+1;i++){
			monteurLinkedList.add(new Monteur());
			monteurLinkedList.start();
		}

	}


}
