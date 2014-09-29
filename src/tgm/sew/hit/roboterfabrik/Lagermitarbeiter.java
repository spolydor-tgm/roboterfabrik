package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Lagermitarbeiter {

	/**
	 * Speichert den Pfad für die Dateien
	 */
	private String pfad;

	/**
	 * Speichert alle augen, die aus dem entsprechendem File gelesen wurden
	 */
	private Bauteil[] augen;

	/**
	 * Speichert alle arme, die aus dem entsprechendem File gelesen wurden
	 */
	private Bauteil[] arme;

	/**
	 * Speichert alle rumpf, die aus dem entsprechendem File gelesen wurden
	 */
	private Bauteil[] rumpf;

	/**
	 * Speichert alle kettenl, die aus dem entsprechendem File gelesen wurden
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

	public Lagermitarbeiter(String pfad) {
		this.pfad = pfad;
	}

	public void pushRoboter(Roboter roboter) {

	}
}
