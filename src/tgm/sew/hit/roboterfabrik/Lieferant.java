package tgm.sew.hit.roboterfabrik;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Patrick on 29.09.14.
 */
public class Lieferant {
	ArrayList<String> inhalt = new ArrayList<String>();
	String verzeichnis="";
	String[] bauteilarten=new String[4];
	ArrayList<Integer> usedprng = new ArrayList<Integer>();

	public Lieferant(String verzeichnis){
		this.verzeichnis=verzeichnis;
		bauteilarten[0]="arm";
		bauteilarten[1]="auge";
		bauteilarten[2]="rumpf";
		bauteilarten[3]="kettenantrieb";
	}


	public void liefern(int anzahl ){

		for(int i = 0;i<anzahl;i++) {
			Random rand = new Random();
			int randomNum = rand.nextInt((4 - 1) + 1) + 1;
			randomNum=randomNum-1;
			File file_speichern = new File(verzeichnis + "/" +bauteilarten[randomNum]+".csv");
			this.readFile(file_speichern,bauteilarten[randomNum]);
			try {
				RandomAccessFile raf = new RandomAccessFile(verzeichnis + "/" +bauteilarten[randomNum]+".csv","rw");
				raf.seek(raf.length());
				raf.writeUTF(bauteilarten[randomNum]+this.generateGanzzahlen(bauteilarten[randomNum]));
				raf.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void readFile(File filezumeinlesen,String name){
		ArrayList<String> inhalt = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(filezumeinlesen);
			while(scanner.hasNextLine()){
				inhalt.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.inhalt=inhalt;

	}

	public String generateGanzzahlen(String typ){
		boolean uniqe=true;
		String ganzzahl="";
		do {
			Random rand = new Random();
			int randomNum = 0;
			for (int i = 0; i < 20; i++) {
				randomNum = rand.nextInt((500 - 1) + 1) + 1;
				if (i == 0)
					ganzzahl += randomNum;

				ganzzahl += "," + randomNum;
			}
			Iterator<String> iterator = this.inhalt.iterator();

			while(iterator.hasNext()) {
				if (iterator.next().regionMatches(typ.length(), ganzzahl, 0,ganzzahl.length() )){
						uniqe=false;
				}
			}
		}while(uniqe == false);
		return ganzzahl;

	}

}
