/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package utilities;

import java.io.IOException;
import java.util.logging.*;


/**
 *
 * @author Tuan Nguyen
 */
public class LearnLogger {

    private static Logger theLogger =
	 Logger.getLogger(LearnLogger.class.getName());
    private static FileHandler fileTxt;    
    private static FileHandler fileXML;

    private static SimpleFormatter formatterTxt;



    public static void anotherError(){

        byte i=125 ;
        try{
        for (int j=1 ; j<1000000; j++){
            i = (byte) (i/0);
        }
        }catch (Exception e){
            // Divide by zero
          theLogger.severe(e.toString());
        }


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        theLogger.setLevel(Level.FINEST);
        fileXML = new FileHandler("LogFile.XML");
        fileTxt.setFormatter(formatterTxt);
        theLogger.addHandler(fileXML);
        anotherError();

        /*
        formatterTxt = new SimpleFormatter();
        fileTxt = new FileHandler("LearnLogger.log");
        fileTxt.setFormatter(formatterTxt);
        theLogger.addHandler(fileTxt);
        */

        anotherError();

        try{
         float f= 10/0;
         
        }catch(Exception e){
            theLogger.info("Logging");
            theLogger.finest("Logging finest");
            theLogger.severe("Server, divided by zero");
            // Divide by zero
            theLogger.severe(e.toString());
            System.err.println(e.toString());
        }
    }

}
