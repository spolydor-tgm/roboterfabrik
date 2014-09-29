package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 29.09.14.
 */
public class Sekretariat {

	/**
	 * Speichern der IDs der Monteure
	 */
	private int[] usedIDs;

	/**
	 *
	 * @return usedIDs gibt die
	 */
	public int[] getUsedIDs() {
		return this.usedIDs;
	}

	public Sekretariat(int anzahl) {
		for (int x = 0; x < anzahl; ) {
			this.usedIDs[x] = 100 + x;
			System.out.println(usedIDs[x]);
		}
	}
}
