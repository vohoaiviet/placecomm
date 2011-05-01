/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.utils;
import java.util.*;
import java.util.logging.*;
import java.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;


/**
 *
 * @author ATuan
 */
public class RandomSpeedGenerator {

    /**
     * @param args the command line arguments
     */



    public static void main(String[] args) {
        // TODO code application logic here

        long lNumOfLines=0;
        List list1=new ArrayList();

          try{
        FileInputStream fstream = new FileInputStream("n:\\myphd\\dataset\\gps.csv");
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
        // Print the content on the console
            lNumOfLines++;
            list1.add(strLine.trim());
        }
        //Close the input stream
        in.close();
    }catch (Exception e){//Catch exception if any
        System.err.println("Error: " + e.getMessage());
    }


        long lTotal=1000000;
        long numberOfLines=0;
        long lStep= lTotal / lNumOfLines;
        System.out.println("lTotal:"+lTotal+" numberOfLines:"+numberOfLines+"lStep:"+lStep);
        float fSpeed=100;
        float newfSpeed=0;
        for (int iNum=0; iNum< lStep; iNum++){
                  Random randomGenerator = new Random();
                  int randomInt = randomGenerator.nextInt(1000);
                  float f= (float)randomInt/10000.0f;
                  System.out.println("Random Int:"+randomInt+" f:"+f);
                  if ((randomInt % 2 )==0){
                  newfSpeed = fSpeed+fSpeed*f;
                  System.out.println("Even");
                  }else {
                      newfSpeed = fSpeed-fSpeed*f;
                      System.out.println("odd");
                  }
                  //InsertInstance(fLat,fLon,fAlt,fSpeed,sDate,sTimestamp,sBTAddress,sBTName,sURI);
                  System.out.println("generated speed:"+newfSpeed);

              }
    }

}
