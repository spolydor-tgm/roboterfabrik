package tgm.sew.hit.roboterfabrik;

import tgm.sew.hit.roboterfabrik.Logging;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class New_CLI {
	private String[] args = null;
	private Options options = new Options();
	
	private Option op_lager = new Option("w","lager",true, "Verzeichnis in dem das Lager verwaltet wird."); //w als warehouse, da 2x "l" nicht geht.
	private Option op_logs = new Option("l","logs",true, "Verzeichnis in dem die Logs verwaltet werden.");
	private Option op_liefer = new Option("s","lieferant",true, "Anzahl der Lieferanten."); //s als supplier.
	private Option op_mont = new Option("m","monteure",true, "Anzahl der anfaenglichen Monteure.");
	private Option op_zeit = new Option("r","laufzeit",true, "Zeit in der das Programm abgearbeitet wird."); //r als runtime

	private String lager;
	private int lieferant;
	private int monteure;
	private int zeit;
	
	public New_CLI(String[] args) {
		this.args = args;

		options.addOption(op_lager);
		options.addOption(op_logs);
		options.addOption(op_liefer);
		options.addOption(op_mont);
		options.addOption(op_zeit);
		
	}

	public void parse() {
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = null;

		try {
			cmd = parser.parse(options, args);
			
				// Verarbeitung vom Lager-Verzeichniss
				if (cmd.hasOption("w")) {
					lager = op_lager.toString();
				} else {
					System.out.println("Fehlende Angabe: \"lager\": " +op_lager.getDescription());
				}
				
				//Verarbeitung vom Logs-Verzeichniss
				if(cmd.hasOption("l")) {
					Logging.verzFestlegen(op_logs.toString());
				} else {
					System.out.println("Fehlende Angabe: \"logs\": " +op_logs.getDescription());
				}
				
				//Verarbeitung der Lieferantenanzahl
				if(cmd.hasOption("s")) {
					lieferant = Integer.parseInt(op_liefer.toString());
				} else {
					System.out.println("Fehlende Angabe: \"lieferant\": " +op_liefer.getDescription());
				}
				
				//Verarbeitung der Monteure-Anzahl
				if(cmd.hasOption("m")) {
					monteure = Integer.parseInt(op_mont.toString());
				} else {
					System.out.println("Fehlende Angabe: \"monteure\": " +op_mont.getDescription());
				}
				
				//Verarbeitung der Runtime
				if(cmd.hasOption("r")) {
					zeit = Integer.parseInt(op_zeit.toString());
				} else {
					System.out.println("Fehlende Angabe: \"laufzeit\": " +op_logs.getDescription());
				}
		} catch (ParseException e) {
			
		}
	}
	
	public String getLager() {
		return lager;
	}
	
	public int getLieferant() {
		return lieferant;
	}
	
	public int getMonteure() {
		return monteure;
	}
	
	public int getZeit() {
		return zeit;
	}
}
