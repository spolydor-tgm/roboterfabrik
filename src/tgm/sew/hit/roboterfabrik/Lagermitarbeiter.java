package tgm.sew.hit.roboterfabrik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Stefan Polydor on 24.09.14.
 */
public class Lagermitarbeiter {

	/**
	 * File f�r die fertigen Threadee's
	 */
	File fileThreadee;

	/**
	 * FileWriter f�r fileThreadee
	 */
	FileWriter fileWriter;

	/**
	 * Speichert den Pfad f�r die Dateien
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
	 * Speichert alle ruempfe, die aus dem entsprechendem File gelesen wurden
	 */
	private Bauteil[] rumpf;

	/**
	 * Speichert alle kettenantriebe, die aus dem entsprechendem File gelesen wurden
	 */
	private Bauteil[] kettenantrieb;


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
	public Bauteil[] getKettenantrieb() {
		return this.kettenantrieb;
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
	 * Schreibt den Fertigen Threadee in das File f�r die fertigen Threadee's
	 * @param roboter der in das Threadee-file geschrieben wird
	 * @return true wenn in das File geschrieben wurde
	 */
	public boolean writeFile(Roboter roboter) {
		if (fileThreadee != null)
			fileThreadee = new File(this.pfad, "auslieferung.csv");
		try {
			fileWriter = new FileWriter(this.fileThreadee, true);
			fileWriter.write(roboterToString(roboter));
			fileWriter.write(System.getProperty("line.seperator")); // Plattformunabhaengiger Zeilenumbruch
			fileWriter.flush(); // Leeren des Streams
			fileWriter.close(); // Writer Stream wird geschlossen
		} catch (IOException e) {
		}
		return true;
	}

	/**
	 *
	 * @param roboter Roboter dessen Informationen zu einem String geschrieben werden, um diese fertig in ein File zu schreiben
	 * @return String fertig um diesen in das File zu schreiben
	 */
	public String roboterToString(Roboter roboter) {
		String seriennr = "Threadee-ID" + roboter.getId() + ", " + roboter.getName() + ",";
		for (int x = 0; x < roboter.getBauteile().length; x++) {
			seriennr = seriennr + roboter.getBauteile()[x].getTyp() + ",";
			for (int y = 0; y < roboter.getBauteile()[x].getSeriennr().length; y++)
				seriennr = seriennr + roboter.getBauteile()[x].getSeriennr()[y] + ",";
		}
		return seriennr;
	}

	/**
	 *
	 */
	private void read() {
		int count;
		int seriennr[];
		String pfad = "";
		Scanner scanner;
		String speichernName = "";
		try {
			for (int x = 0; x < 4; x++) {
				switch (x) {
					case 0:
						pfad = "/arm.csv";
						speichernName = "arm";
						break;
					case 1:
						pfad = "/auge.csv";
						speichernName = "auge";
						break;
					case 2:
						pfad = "/rumpf.csv";
						speichernName = "rumpf";
						break;
					case 3:
						pfad = "/kettenantrieb.csv";
						speichernName = "kettenantrieb";
						break;
				}
				count = 0;
				scanner = new Scanner(new File(this.pfad, pfad));
				while (scanner.hasNextLine())
					count++;
				scanner.close();
				scanner = new Scanner(new File(this.pfad, pfad));
				for (int xx = 0; xx < count; xx++) {
					seriennr = new int[20];
					String[] split = scanner.nextLine().split(",");
					for (int y = 1; y <= 20; y++)
						seriennr[y - 1] = Integer.parseInt(split[y]);
					this.arme[xx] = new Bauteil("arm", seriennr);
					switch (x) {
						case 0: this.arme[xx] = new Bauteil(speichernName, seriennr);
							break;
						case 1: this.augen[xx] = new Bauteil(speichernName, seriennr);
							break;
						case 2: this.rumpf[xx] = new Bauteil(speichernName, seriennr);
							break;
						case 3: this.rumpf[xx] = new Bauteil(speichernName, seriennr);
							break;
					}
				}
				scanner.close();
			}
		} catch (FileNotFoundException e) {
		}
	}

	/**
	 * Liest alle Files (Arme, Auge, Rumpf, Kettenantrieb)
	 * @return true wenn fertig
	 */
	public boolean readFile() {
		this.read();
		return true;
	}

	/**
	 *
	 * @param bauteil
	 * @param position
	 * @return
	 */
	public static String bauteileSeriennrToString(Bauteil[] bauteil, int position) {
		String ret = "";
		int[] bt = bauteil[position].getSeriennr();
		for (int x = 0; x < bt.length; x++)
			ret = ret + "," + bt[x];
		return ret;
	}

	/**
	 *
	 * @return Bauteil[] gibt alle Bauteile f�r einen Roboter zurueck. Dieses Array muss nur noch dem Roboter Konstruktor �bergeben
	 * werden und dieser erzeugt ihn dann. Alle Teile sind schon in der richtigen Reihenfolge.
	 */
	public Bauteil[] getAlleBenoetigtenRoboterTeile() throws ArrayIndexOutOfBoundsException{
		Bauteil[] alleTeile = new Bauteil[6];
		alleTeile[0] = this.getArme()[1];
		alleTeile[1] = this.getArme()[2];
		alleTeile[2] = this.getAugen()[1];
		alleTeile[3] = this.getAugen()[2];
		alleTeile[4] = this.getRumpf()[1];
		alleTeile[5] = this.getKettenantrieb()[1];
		try {
			String pfad = "";
			Bauteil[] teile = null;
			for (int x = 0; x < 4; x++) {
				switch (x) {
					case 0: pfad = "/arm.csv";
						teile = this.getArme();
						break;
					case 1: pfad = "/auge.csv";
						teile = this.getAugen();
						break;
					case 2: pfad = "/rumpf.csv";
						teile = this.getRumpf();
						break;
					case 3: pfad = "/kettenantrieb.csv";
						teile = this.getKettenantrieb();
						break;
				}
				fileWriter = new FileWriter(this.pfad + pfad, true);
				for (int y = 0; y < teile.length; y++) {
					fileWriter.write(teile[y].getTyp() + Lagermitarbeiter.bauteileSeriennrToString(teile, y));
					fileWriter.write(System.getProperty("line.seperator")); // Plattformunabhaengiger Zeilenumbruch
				}
				fileWriter.flush(); // Leeren des Streams
				fileWriter.close(); // Writer Stream wird geschlossen
			}
		} catch (IOException e) {
		}
		return alleTeile;
	}
}