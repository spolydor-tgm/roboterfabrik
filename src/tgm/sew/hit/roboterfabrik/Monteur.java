package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Monteur extends Thread {

	/**
	 * ID des Monteurs
	 */
	private int id;

	/**
	 * Der fertige Roboter
	 */
	private Roboter Roboterfertig;

	private Bauteil[] bauteile;


	/**
	 *
	 * @return gibt die ID des Monteurs zurueck
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * baut den Threadee zusammen
	 * @return true wenn der Threadee fertig zusammengebaut ist
	 */
	public boolean bauen() {
		Roboterfertig = new Roboter(this.bauteile, this.id);
		return true;
	}

	/**
	 *
	 * @param id des Monteurs (eindeutige Nummer)
	 */
	public Monteur(int id) {
		this.id = id;
	}

	/**
	 *
	 * @return gibt den fertig zusammengebauten Roboter zurueck
	 */
	public Roboter getRoboter() {
		return this.Roboterfertig;
	}

	/**
	 *
	 * @param bauteile
	 */
	public void setBauteile(Bauteil[] bauteile) {
		this.bauteile = bauteile;
	}
}