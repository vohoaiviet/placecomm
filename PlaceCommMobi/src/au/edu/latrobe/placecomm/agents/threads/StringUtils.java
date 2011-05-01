/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.latrobe.placecomm.agents.threads;

/**
 *
 * @author ATuan
 */
public class StringUtils {

public StringUtils() {
        // This is the constructor :-)
    }

    /*
     @param str
      return a byte array byte[] from the string input.
     */
     public static byte[] StringToByte (String str){
        int iLen=str.length();
        byte[] bResult=new byte[iLen];
        for (int j=0; j<iLen ; j++){
            bResult[j]=(byte) str.charAt(j);

        }
        return bResult;
    }
}

