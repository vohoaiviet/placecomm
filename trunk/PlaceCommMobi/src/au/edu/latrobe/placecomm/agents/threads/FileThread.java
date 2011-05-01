/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents.threads;
import java.io.OutputStream;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
import javax.microedition.io.file.*;

import au.edu.latrobe.placecomm.agents.*;
/**
 *
 * @author ATuan
 */
public class FileThread  implements Runnable{


    private String strFilename;
    private String [] sDataLocal;
    private MobileUserAgentGUIDesign  MIDlet;

    public FileThread(MobileUserAgentGUIDesign MIDlet, String sFilename, String [] sData)  {
        
        this.strFilename=sFilename;
        this.sDataLocal = sData;
        this.MIDlet =MIDlet ;

    }

    //public void SavingToFile(String sFilename,Form localPlaceAwareVNform){
    public void SavingToFile(String sFilename,String [] sDataLocal){

        

        try {
        FileConnection fconn = (FileConnection)
                Connector.open("file://localhost/e:/pbvc/"+sFilename);
                //Connector.open("file://localhost/c:/"+sFilename);
                //+";append=true",Connector.READ_WRITE);

        OutputStream os;
     // If no exception is thrown, then the URI is valid, but the file may or may not exist.
     if (!fconn.exists()) {
         fconn.create();  // create the file if it doesn't exist
         os = fconn.openOutputStream();
     }else {
         os = fconn.openOutputStream();
     }
        int lstSize =sDataLocal.length;
        System.out.println("From SavingToFile. ");
        for (int i=0; i< lstSize; i++){
            System.out.println(sDataLocal[i]);
            byte[] bToWrite = StringUtils.StringToByte(sDataLocal[i]);
            System.out.println(bToWrite.toString());
            os.write(bToWrite);
            os.write(13);
        }

       os.close();
       fconn.close();
     }catch (Exception ioe) {
         //MIDlet.logString(ioe.toString());
         //MIDlet.LogScreenAppend(ioe.toString());
     }
    }

public void start() {
    Thread thread = new Thread(this);
    try {
      thread.start(); // Call run()
    } catch (Exception error) {
    }
}

    public void run() {
     try {
         //SavingToFile(strFilename,localPlaceAwareVNform);
         SavingToFile(strFilename,sDataLocal);
     }
     catch (Exception error) {
         System.err.println(error.toString());
     }

    }


}
