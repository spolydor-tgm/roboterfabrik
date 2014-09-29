package tgm.sew.hit.roboterfabrik.Simulation;

import java.util.Arrays;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Roboter {

	/**
	 * Die ID des Roboters
	 */
	private int id;

	/**
	 * Die verwendeten Bauteile für den Roboter
	 */
	private Bauteil[] verwBauteile;

	/**
	 * Name des Roboters
	 */
	private String name;

	/**
	 * Erstellt einen Roboter
	 * @param bauteile sind die Bauteile die zur Erstellung des Roboters benötigt werden.
	 *                 Reihenfolge: Arm, Arm, Auge Auge, Rumpf, Kettenl
	 */
	public Roboter(Bauteil[] bauteile, int id) {
		this.id = id;
		this.verwBauteile = bauteile;
		this.name = "Threadee-" + id;
		int[] sort;
		for (int x = 0; x < bauteile.length; x++) {
			sort = bauteile[x].getSeriennr();
			Arrays.sort(sort);
			verwBauteile[x].setSeriennr(sort);
		}
	}

	/**
	 *
	 * @return id des Roboters
	 */
	public int getId() {
		return this.id;
	}

	/**
	 *
	 * @return bauteile gibt die verwendeten Bauteile zurueck
	 */
	public Bauteil[] getBauteile() {
		return this.verwBauteile;
	}
}