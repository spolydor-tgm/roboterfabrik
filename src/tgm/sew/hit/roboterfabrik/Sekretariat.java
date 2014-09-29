package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 29.09.14.
 */
public class Sekretariat {

	/**
	 * Speichern der IDs der Monteure
	 */
	private int[] uniqueIDs;

	/**
	 * Nummerierung der Threadee's
	 */
	private int id = 1;

	/**
	 *
	 * @return usedIDs gibt die
	 */
	public int[] getUniqueIDs() {
		return this.uniqueIDs;
	}

	/**
	 *
	 * @param anzahl wieviele Monteure es gibt, dadurch wird angegeben wieviele ID's erzeugt werden muessen
	 */
	public Sekretariat(int anzahl) {
		for (int x = 0; x < anzahl; ) {
			this.uniqueIDs[x] = 100 + x;
			System.out.println(uniqueIDs[x]);
		}
	}

	/**
	 *
	 * @return die fortlaufende Nummer der Threadee's
	 */
	public int getId() {
		this.id++;
		return  this.id - 1;
	}
}
