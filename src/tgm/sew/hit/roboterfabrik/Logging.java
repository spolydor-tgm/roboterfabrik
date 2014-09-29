package tgm.sew.hit.roboterfabrik;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging{
  /* Get actual class name to be printed on */
  static Logger log = Logger.getLogger(Logging.class.getName());
  
	public static void verzFestlegen(String verz) {
		PrintWriter writer;
	try {
		
		writer = new PrintWriter("lib/log4j.properties", "UTF-8");
		writer.println("# Define the root logger with appender file");
		writer.println("log = " +verz);
		writer.println("log4j.rootLogger = INFO, FILE" +"\n"); //Inkl Leere Zeile
		writer.println("# Define the file appender");
		writer.println("log4j.appender.FILE=org.apache.log4j.FileAppender");
		writer.println("log4j.appender.FILE.File=${log}/log.out" +"\n"); //Inkl Leere Zeile
		writer.println("# Define the layout for file appender");
		writer.println("log4j.appender.FILE.layout=org.apache.log4j.PatternLayout");
		writer.println("log4j.appender.FILE.layout.conversionPattern=%m%n");
		
		writer.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
  }
  
  
  public static void writeLog(String bericht) {
	  //Erzeugen eines Datum im Log ordentlich zu protokollieren.
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
	  //Speichern des Datums und der Taetigkeit ins File.
	  log.info(dateFormat.format(date) +" " +bericht);
  }

  public static void main(String[] args) {
	 verzFestlegen("C:/Users/84N3/git/roboterfabrik");
     writeLog("test123");
  }
}