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
	 *
	 * @return usedIDs gibt die
	 */
	public int[] getUniqueIDs() {
		return this.uniqueIDs;
	}

	public Sekretariat(int anzahl) {
		for (int x = 0; x < anzahl; ) {
			this.uniqueIDs[x] = 100 + x;
			System.out.println(uniqueIDs[x]);
		}
	}
}
