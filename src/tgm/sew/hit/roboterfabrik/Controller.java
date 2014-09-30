package tgm.sew.hit.roboterfabrik;

import java.util.LinkedList;

/**
 * Created by Patrick on 29.09.14.
 */
public class Controller {

	public static void main(String[] args) {
		CLI commandlineinterface = new CLI();
		LinkedList<Monteur> monteurLinkedList = new LinkedList<Monteur>();
		Sekretariat sekretariat = new Sekretariat(commandlineinterface.getMonteur());
		 //logverzeichnis(commandlineinterface.getLager());

		Lagermitarbeiter lagermit = new Lagermitarbeiter(commandlineinterface.getLager());
		Lieferant lieferant = new Lieferant(commandlineinterface.getLager());
		TimerWD timer= new TimerWD(commandlineinterface.getZeit());

		int[] ids = sekretariat.getUniqueIDs();

		lieferant.liefern(commandlineinterface.getLieferant());
		for(int i = 0;i<commandlineinterface.getMonteur()+1;i++){
			monteurLinkedList.add(new Monteur(ids[i]));
			monteurLinkedList.get(i).start();
			monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
			monteurLinkedList.get(i).bauen(sekretariat.getId());
		}

		do {
			lieferant.liefern(commandlineinterface.getLieferant());
			for (int i = 0; i < commandlineinterface.getMonteur() + 1; i++) {
				Roboter fertigrobo = monteurLinkedList.get(i).getRoboter();
				lagermit.writeFile(fertigrobo);
				monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
				monteurLinkedList.get(i).bauen(sekretariat.getId());
			}
		}while( timer.tokeepRunning() == true);
	}
}
