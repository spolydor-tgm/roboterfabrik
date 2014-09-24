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


	/**
	 *
	 * @return gibt die ID des Monteurs zurueck
	 */
	public int getID() {
		return this.id;
	}

	public boolean bauen() {
		return true;
	}

	/**
	 *
	 * @return gibt den fertig zusammengebauten Roboter zurueck
	 */
	public Roboter getRoboter() {
		return this.Roboterfertig;
	}
}
