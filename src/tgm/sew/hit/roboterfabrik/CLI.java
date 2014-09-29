package tgm.sew.hit.roboterfabrik;

import org.apache.commons.cli.*;

public class CLI {
	private Object zahl = new Integer(0);
	
	private CommandLineParser Parser = new BasicParser();

	private Options angaben = new Options();
	
	private Option op_lager = new Option("w","lager",true, "Verzeichnis in dem das Lager verwaltet wird."); //w als warehouse, da 2x "l" nicht geht.
	private Option op_logs = new Option("l","logs",true, "Verzeichnis in dem die Logs verwaltet werden.");
	private Option op_liefer = new Option("s","lieferant",true, "Anzahl der Lieferanten."); //s als supplier.
	private Option op_mont = new Option("m","monteure",true, "Anzahl der anfaenglichen Monteure.");
	private Option op_zeit = new Option("r","laufzeit",true, "Zeit in der das Programm abgearbeitet wird."); //r als runtime
	
	private String[] args = {"test"}; //Wozu genau ist das gut?
	
	private CommandLine lvCmd = null;
	
	private HelpFormatter hilfe = new HelpFormatter();
	
	public CLI() {
		
		//Sorgt dafuer das die folgenden Optionen einen Parameter haben muessen.
		op_lager.setRequired(true);
		op_logs.setRequired(true);
		op_liefer.setRequired(true);
		op_mont.setRequired(true);
		op_zeit.setRequired(true);
		
		//Legt fuer alle dafuer vorgesehenen Optionen fest das diese Zahlen entgegen nehmen.
		
		op_liefer.setType(zahl);
		op_mont.setType(zahl);
		op_zeit.setType(zahl);
		
		//Optionen werden zur OptionenListe hinzugefuegt.
		angaben.addOption(op_lager);
		angaben.addOption(op_logs);
		angaben.addOption(op_liefer);
		angaben.addOption(op_mont);
		angaben.addOption(op_zeit);
		
		//Simple Hilfestellung, bei der die Beschreibung der Optionen ausgegeben werden.
		hilfe.printHelp("Roboterfabrik", angaben);
		
		try {
		            lvCmd = Parser.parse(angaben, args);
		    } catch (ParseException pvException) {
		            System.out.println(pvException.getMessage());
		    }
		
	}
	
	public String getLager() {
		return lvCmd.getOptionValue("w");
	}

	public String getLogs() {
		return lvCmd.getOptionValue("l");
	}

	public int getLieferant() {
		return Integer.parseInt(lvCmd.getOptionValue("s"));
	}

	public int getMonteur() {
		return Integer.parseInt(lvCmd.getOptionValue("m"));
	}
	
	public int getZeit() {
		return Integer.parseInt(lvCmd.getOptionValue("r"));
	}

	public static void main(String[] args) {
		CLI test = new CLI();
	}
	
}
