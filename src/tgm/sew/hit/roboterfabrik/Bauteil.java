package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Bauteil {

	/**
	 * Ist der Typ des Bauteils. z.B.: "arm"
	 */
	private String typ;

	/**
	 * Zahlen des Bauteils
	 */
	private int[] seriennr;

	/**
	 *
	 * @return gibt die seriennr des Bauteil's zurueck
	 */
	public int[] getSeriennr() {
		return this.seriennr;
	}

	/**
	 *
	 * @return typ gibt den Typ (z.B.: Auge) zurueck
	 */
	public String getTyp() {
		return this.typ;
	}

	/**
	 *
	 * @param seriennr setzt die sortierte seriennummer in der Klasse Lagermitarbeiter
	 */
	public void setSeriennr(int[] seriennr) {
		this.seriennr = seriennr;
	}

	/**
	 *
	 * @param typ gibt an, welche art dieser Bauteil ist. Gueltige eingaben: "arm", "auge", "rumpf", "kettenantrieb"
	 * @param seriennr Nummer der Bauteile (z.B.: 1,3,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
	 */
	public Bauteil(String typ, int[] seriennr) {
		this.typ = typ;
		this.seriennr = seriennr;
	}

	/**
	 *
	 * @return 1 wenn das Bauteil ein arm ist, 2 wenn es ein auge ist, 3 wenn es ein rumpf ist,
	 * 4 wenn es ein kettenantrieb ist und 0 wenn es keines der vorher angeführten Typen ist
	 */
	public int isTyp() {
		switch (this.typ) {
			case "arm":
				return 1;
			case "auge":
				return 2;
			case "rumpf":
				return 3;
			case "kettenantrieb":
				return 4;
		}
		return 0;
	}
}