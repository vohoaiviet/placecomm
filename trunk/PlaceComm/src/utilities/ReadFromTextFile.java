/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

/**
 *
 * @author ATuan
 */
import java.io.*;

public class ReadFromTextFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      try{
    // Open the file that is the first
    // command line parameter
    FileInputStream fstream = new FileInputStream("textfile.txt");
    // Get the object of DataInputStream
    DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
      // Print the content on the console
      System.out.println (strLine);
    }
    //Close the input stream
    in.close();
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}
 