/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.utils;

import java.io.*;

/**
 *
 * @author ATuan
 */
public class FileThread implements Runnable{


    private String strFilename;
    private String sLogs;
    private SimpleTCPserver tcpServer;

    public FileThread(SimpleTCPserver tcpServer, String sFilename, String sLogs)  {

        this.strFilename=sFilename;
        this.tcpServer=tcpServer;
        this.sLogs = sLogs;
    }

    public void SavingToFile(String strFilename,String sLogs){

        try {
        FileOutputStream out; // declare a file output object
        PrintStream p; // declare a print stream object

            out = new FileOutputStream(strFilename,true);
            // Connect print stream to the output stream
            p = new PrintStream( out );
            p.println (sLogs);
            //p.println ("Inet Address: "+socket.getInetAddress().toString());
            p.close();
        }
        catch (Exception ioe) {
            System.out.println("File error:"+ioe.toString());
        }


    }

    public void run() {
     try {
         SavingToFile(strFilename,sLogs);
     }
     catch (Exception error) {
         System.err.println(error.toString());
     }

    }
}

