package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Bauteil {

	/**
	 * Ist der Typ des Bauteils. z.B.: "Arm"
	 */
	private String typ;

	/**
	 * Zahlen des Bauteils
	 */
	private int[] seriennr;

	/**
	 *
	 * @return 1 wenn das Bauteil ein arm ist, 2 wenn es ein auge ist, 3 wenn es ein rumpf ist, 4 wenn es ein kettenl ist und 0 wenn es keines der vorher angeführten Typen ist
	 */
	public Integer isTyp() {
		switch (this.typ) {
			case "arm":
				return 1;
			case "auge":
				return 2;
			case "rumpf":
				return 3;
			case "kettenl":
				return 4;
		}
		return 0;
	}
}
