package tgm.sew.hit.roboterfabrik;

import java.util.Arrays;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Roboter {

	/**
	 * Die ID des Roboters
	 * Fortlaufend zu nummerieren
	 */
	private int id;

	/**
	 * Die verwendeten Bauteile fuer den Roboter
	 */
	private Bauteil[] verwBauteile;

	/**
	 * Name des Roboters (Mitarbeiter + ID des Mitarbeiters)
	 */
	private String name;

	/**
	 * Erstellt einen Roboter
	 * @param bauteile sind die Bauteile die zur Erstellung des Roboters benoetigt werden.
	 *                 Reihenfolge: Arm, Arm, Auge Auge, Rumpf, Kettenl
	 * @param name Der Name des Mitarbeiters (Mitarbeiter-ID123)
	 */
	public Roboter(Bauteil[] bauteile, int id, String name) {
		this.id = id;
		this.verwBauteile = bauteile;
		this.name = name;
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
	 * @return gibt den Namen des Roboters zurueck
	 */
	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @return bauteile gibt die verwendeten Bauteile zurueck
	 */
	public Bauteil[] getBauteile() {
		return this.verwBauteile;
	}
}