package tgm.sew.hit.roboterfabrik;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class log4jExample{
  /* Get actual class name to be printed on */
  static Logger log = Logger.getLogger(log4jExample.class.getName());
  
  public static void writeLog(String aufgabe) {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
	  log.info(dateFormat.format(date) +" " +aufgabe);
  }

  public static void main(String[] args)
                throws IOException,SQLException{
   
     writeLog("test123");
  }
}