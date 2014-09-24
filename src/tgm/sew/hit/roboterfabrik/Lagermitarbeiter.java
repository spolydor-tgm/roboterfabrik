package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Lagermitarbeiter {
	/**
	 *
	 */
	private Bauteil[] augen;

	/**
	 *
	 */
	private Bauteil[] arme;

	/**
	 *
	 */
	private Bauteil[] rumpf;

	/**
	 *
	 */
	private Bauteil[] kettenl;


	/**
	 *
	 * @return arme gibt die Arme zur Weiterverwendung zurueck
	 */
	public Bauteil[] getArme() {
		return this.arme;
	}


	/**
	 *
	 * @return augen gibt die Augen zur Weiterverwendung zurueck
	 */
	public Bauteil[] getAugen() {
		return this.augen;
	}

	/**
	 *
	 * @return rumpf gibt die Ruempfe zur Weiterverwendung zurueck
	 */
	public Bauteil[] getRumpf() {
		return this.rumpf;
	}

	/**
	 *
	 * @return kettenl gibt die Ketten zur Weiterverwendung zurueck
	 */
	public Bauteil[] getKettenl() {
		return this.kettenl;
	}


	public void pushRoboter(Roboter roboter) {

	}
}
