package tgm.sew.hit.roboterfabrik;

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
	 * @param bauteile sind die Bauteile die zur Erstellung des Roboters benötigt werden
	 */
	public Roboter(Bauteil[] bauteile) {

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
