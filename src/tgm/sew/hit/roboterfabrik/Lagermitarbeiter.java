package tgm.sew.hit.roboterfabrik;

import java.io.*;

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
	 * Position im Array von den rumpf und kettenl, da von diesen immer 1 f�r einen Roboter ben�tigt werden
	 */
	private int standArray1 = 0;

	/**
	 * Position im Array von den Augen und Armen, da von diesen immer 2 f�r einen Roboter ben�tigt werden
	 */
	private int standArray2 = 0;

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
			e.printStackTrace();
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
	 * Liest alle Files (Auge, Arme, Rumpf, Kettenl)
	 * @return true wenn fertig
	 */
	public boolean readFile() {
		BufferedReader in = null;
		int count = 0;
		int seriennr[];
		String pfad = this.pfad + "/arm.csv";
		try {
			in = new BufferedReader(new FileReader(pfad));
				while ( in.readLine() != null ) {
				count++;
			}
			in.close();
			in = new BufferedReader(new FileReader(pfad));
			this.arme = new Bauteil[count];
			for (int x = 0; x < count; x++) {
				seriennr = new int[20];
				String[] split = in.readLine().split(",");
				for (int y = 1; y <= 20; y++)
					seriennr[y-1] = Integer.parseInt(split[y]);
				this.arme[x] = new Bauteil("arm", seriennr);
			}

			in.close();
			pfad = this.pfad + "/auge.csv";
			in = new BufferedReader(new FileReader(pfad));
			while ( in.readLine() != null ) {
				count++;
			}
			in.close();
			in = new BufferedReader(new FileReader(pfad));
			this.arme = new Bauteil[count];
			for (int x = 0; x < count; x++) {
				seriennr = new int[20];
				String[] split = in.readLine().split(",");
				for (int y = 1; y <= 20; y++)
					seriennr[y-1] = Integer.parseInt(split[y]);
				this.arme[x] = new Bauteil("auge", seriennr);
			}

			in.close();
			pfad = this.pfad + "/rumpf.csv";
			in = new BufferedReader(new FileReader(pfad));
			while ( in.readLine() != null ) {
				count++;
			}
			in.close();
			in = new BufferedReader(new FileReader(pfad));
			this.arme = new Bauteil[count];
			for (int x = 0; x < count; x++) {
				seriennr = new int[20];
				String[] split = in.readLine().split(",");
				for (int y = 1; y <= 20; y++)
					seriennr[y-1] = Integer.parseInt(split[y]);
				this.arme[x] = new Bauteil("rumpf", seriennr);
			}

			in.close();
			pfad = this.pfad + "/kettenantrieb.csv";
			in = new BufferedReader(new FileReader(pfad));
			while ( in.readLine() != null ) {
				count++;
			}
			in.close();
			in = new BufferedReader(new FileReader(pfad));
			this.arme = new Bauteil[count];
			for (int x = 0; x < count; x++) {
				seriennr = new int[20];
				String[] split = in.readLine().split(",");
				for (int y = 1; y <= 20; y++)
					seriennr[y-1] = Integer.parseInt(split[y]);
				this.arme[x] = new Bauteil("kettenantrieb", seriennr);
			}

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return true;
	}

	/**
	 *
	 * @return Bauteil[] gibt alle Bauteile f�r einen Roboter zurueck. Dieses Array muss nur noch dem Roboter Konstruktor �bergeben
	 * werden und dieser erzeugt ihn dann. Alle Teile sind schon in der richtigen Reihenfolge.
	 */
	public Bauteil[] getAlleBenoetigtenRoboterTeile() {
		Bauteil[] alleTeile = new Bauteil[6];
		alleTeile[0] = this.getArme()[this.standArray2];
		alleTeile[1] = this.getArme()[this.standArray2 + 1];
		alleTeile[2] = this.getAugen()[this.standArray2];
		alleTeile[3] = this.getAugen()[this.standArray2 + 1];
		//this.standArray2++;
		alleTeile[4] = this.getRumpf()[this.standArray1];
		alleTeile[5] = this.getKettenantrieb()[this.standArray1];
		//this.standArray1++;

		return alleTeile;
	}
}