package tgm.sew.hit.roboterfabrik;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Lagermitarbeiter {

	/**
	 * Position im Array von den rumpf und kettenl, da von diesen immer 1 für einen Roboter benötigt werden
	 */
	private int standArray1 = 0;

	/**
	 * Position im Array von den Augen und Armen, da von diesen immer 2 für einen Roboter benötigt werden
	 */
	private int standArray2 = 0;

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

	/**
	 * Erzeugung einen Lagermitarbeiters
	 * Lesen aller Files (Auge, Arme, Rumpf, Kettenl) und speichern in die Arrays
	 * @param pfad fuer den Ort der Files
	 */
	public Lagermitarbeiter(String pfad) {
		this.pfad = pfad;

	}

	/**
	 * Schreibt den Fertigen Threadee in das File für die fertigen Threadee's
	 * @param roboter der in das Threadee-file geschrieben wird
	 * @return true wenn in das File geschrieben wurde
	 */
	public boolean writeFile(Roboter roboter) {

		return true;
	}

	/**
	 * Liest alle Files (Auge, Arme, Rumpf
	 * @return
	 */
	public boolean readFile() {

		return true;
	}

	/**
	 *
	 * @return Bauteil[] gibt alle Bauteile für einen Roboter zurueck. Dieses Array muss nur noch dem Roboter Konstruktor übergeben
	 * werden und dieser erzeugt ihn dann. Alle Teile sind schon in der richtigen Reihenfolge.
	 */
	public Bauteil[] getAlleBenoetigtenRoboterTeile() {
		Bauteil[] alleTeile = new Bauteil[6];
		alleTeile[1] = this.getArme()[this.standArray2];
		alleTeile[2] = this.getArme()[this.standArray2 + 1];
		alleTeile[3] = this.getAugen()[this.standArray2];
		alleTeile[4] = this.getAugen()[this.standArray2 + 1];
		this.standArray2++;
		alleTeile[5] = this.getRumpf()[this.standArray1];
		alleTeile[6] = this.getKettenl()[this.standArray1];
		this.standArray1++;

		return alleTeile;
	}
}