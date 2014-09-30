package tgm.sew.hit.roboterfabrik;

import java.util.LinkedList;

/**
 * Created by Patrick on 29.09.14.
 */
public class Controller {

	public static void main(String[] args) {

		new New_CLI(args).parse();
		LinkedList<Monteur> monteurLinkedList = new LinkedList<Monteur>();
		Sekretariat sekretariat = new Sekretariat(New_CLI.getMonteure());
		 //logverzeichnis(commandlineinterface.getLager());

		Lagermitarbeiter lagermit = new Lagermitarbeiter(New_CLI.getLager());
		Lieferant lieferant = new Lieferant(New_CLI.getLager());
		TimerWD timer= new TimerWD(New_CLI.getZeit());

		int[] ids = sekretariat.getUniqueIDs();

		lieferant.liefern(New_CLI.getLieferant());
		for(int i = 0;i<New_CLI.getMonteure()+1;i++){
			monteurLinkedList.add(new Monteur(ids[i]));
			monteurLinkedList.get(i).start();
			monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
			monteurLinkedList.get(i).bauen(sekretariat.getId());
		}

		do {
			lieferant.liefern(New_CLI.getLieferant());
			for (int i = 0; i < New_CLI.getMonteure() + 1; i++) {
				Roboter fertigrobo = monteurLinkedList.get(i).getRoboter();
				lagermit.writeFile(fertigrobo);
				monteurLinkedList.get(i).setBauteile(lagermit.getAlleBenoetigtenRoboterTeile());
				monteurLinkedList.get(i).bauen(sekretariat.getId());
			}
		}while( timer.tokeepRunning() == true);
	}
}
