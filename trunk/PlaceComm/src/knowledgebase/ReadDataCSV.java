/*
 *  Tuan Anh Nguyen.  Email: t.nguyen@latrobe.edu.au
 * Computer Science & Computer Engineering Department
 * La Trobe University, VIC, 3086
 */

package knowledgebase;

import java.io.*;

/**
 *
 * @author Tuan Nguyen
 */
public class ReadDataCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     String filename="d:\\temp\\comorea\\EasternFreeway.csv";

     try {

      BufferedReader input =  new BufferedReader(new FileReader(filename));
      try {
        String line = null; //not declared within while loop
        int j=0;
        while (( line = input.readLine()) != null){
          String words[]=line.split(",");
          System.out.println("line ["+j+"] "+line);
          for (int i=0; i<words.length; i++)        {
              System.out.print("Word ["+i+"]: "+words[i]);
          }
         j++;
         System.out.println("\n");
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }

    }

}
