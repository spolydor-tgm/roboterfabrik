package tgm.sew.hit.roboterfabrik;

import org.apache.commons.cli.*;

public class CLI {
	CommandLineParser Parser = new BasicParser();

	Options angaben = new Options();
	
	Option op_lager = new Option("w","lager",true, "Verzeichnis in dem das Lager verwaltet wird."); //w als warehouse, da 2x "l" nicht geht.
	Option op_logs = new Option("l","logs",true, "Verzeichnis in dem die Logs verwaltet werden.");
	Option op_liefer = new Option("s","lieferant",true, "Anzahl der Lieferanten."); //s als supplier.
	Option op_mont = new Option("m","monteure",true, "Anzahl der anfaenglichen Monteure.");
	Option op_zeit = new Option("r","laufzeit",true, "Zeit in der das Programm abgearbeitet wird."); //r als runtime
	
	String[] args = {"test"};
	
	public CLI() {
		
		//Sorgt dafuer das die folgenden Optionen einen Parameter haben muessen.
		op_lager.setRequired(true);
		op_logs.setRequired(true);
		op_liefer.setRequired(true);
		op_mont.setRequired(true);
		op_zeit.setRequired(true);
		
		//Optionen werden zur OptionenListe hinzugefuegt.
		angaben.addOption(op_lager);
		angaben.addOption(op_logs);
		angaben.addOption(op_liefer);
		angaben.addOption(op_mont);
		angaben.addOption(op_zeit);
		
		//Simple Hilfestellung, bei der die Beschreibung der Optionen ausgegeben werden.
		HelpFormatter hilfe = new HelpFormatter();
		hilfe.printHelp("Roboterfabrik", angaben);
		
		CommandLine lvCmd = null;
		try {
		            lvCmd = Parser.parse(angaben, args);
		    } catch (ParseException pvException) {
		            System.out.println(pvException.getMessage());
		    }
		
	}
	
	public static void main(String[] args) {
		CLI test = new CLI();
	}
	
}
