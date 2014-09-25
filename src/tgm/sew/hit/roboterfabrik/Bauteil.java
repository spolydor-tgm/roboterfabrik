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
	 * @param typ gibt an, welche art dieser Bauteil ist. Gültige eingaben: "arm", "auge", "rumpf", "kettenl"
	 * @param seriennr
	 * @throws IllegalAccessException
	 */
	public Bauteil(String typ, int[] seriennr) throws IllegalAccessException {
		if (typ.equals("arm"))
			seriennr = new int[2];
		else if (typ.equals("auge"))
			seriennr = new int[2];
		else if (typ.equals("rumpf"))
			seriennr = new int[1];
		else if (typ.equals("kettenl"))
			seriennr = new int[1];
		else throw new IllegalAccessException();
		this.typ = typ;
		this.seriennr = seriennr;
	}

	/**
	 *
	 * @return 1 wenn das Bauteil ein arm ist, 2 wenn es ein auge ist, 3 wenn es ein rumpf ist, 4 wenn es ein kettenl ist und 0 wenn es keines der vorher angeführten Typen ist
	 */
	public int isTyp() {
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
